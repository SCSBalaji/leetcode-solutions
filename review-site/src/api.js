// api.js
// All data-fetching and pure logic for the review site, kept separate from
// React components so it can be tested and reasoned about independently.

const GITHUB_OWNER = "scsbalaji";
const GITHUB_REPO = "leetcode-solutions";
const BRANCH = "main";

// The Worker URL from Stage 4, already deployed and confirmed working:
// {"ok":true,"problem":"3954"}
const WORKER_URL = "https://leetcode-review-worker.chaitanyasatyabalaji.workers.dev";

const WORKER_SECRET_STORAGE_KEY = "leetcode_review_worker_secret";

// ---------------------------------------------------------------------------
// URL building
// ---------------------------------------------------------------------------

/**
 * Builds a raw.githubusercontent.com URL for a given repo-relative path.
 * Encodes each path segment independently so spaces (e.g. in "1. easy/...")
 * become %20 without the "/" separators themselves getting encoded.
 */
export function buildRawUrl(path) {
  const encodedPath = path
    .split("/")
    .map(encodeURIComponent)
    .join("/");
  return `https://raw.githubusercontent.com/${GITHUB_OWNER}/${GITHUB_REPO}/${BRANCH}/${encodedPath}`;
}

// ---------------------------------------------------------------------------
// Worker secret (localStorage)
// ---------------------------------------------------------------------------

export function getStoredSecret() {
  try {
    return localStorage.getItem(WORKER_SECRET_STORAGE_KEY);
  } catch (err) {
    // localStorage can throw in some private-browsing contexts.
    return null;
  }
}

export function storeSecret(secret) {
  localStorage.setItem(WORKER_SECRET_STORAGE_KEY, secret);
}

export function clearStoredSecret() {
  localStorage.removeItem(WORKER_SECRET_STORAGE_KEY);
}

// ---------------------------------------------------------------------------
// Recently-marked-reviewed tracking (localStorage)
//
// The Worker returns success the moment GitHub *accepts* the dispatch
// request — not once the downstream Actions workflow has actually finished
// running and pushed the commit to reviews.json. That gap is normally a
// few seconds, but can occasionally run longer. If the page is reloaded
// during that gap, a fresh fetch of reviews.json can still show the OLD,
// pre-mark data — making an already-marked problem look due again. Marking
// it a second time in that state causes a real double-increment of
// review_count on GitHub, since each mark is a genuine dispatch, not just
// a UI action.
//
// This tracks a local record of "I successfully marked this reviewed" that
// survives a reload (in-memory React state doesn't), and is used to
// suppress a problem from the due list even if a freshly-fetched
// reviews.json hasn't caught up yet. The record is dropped once a fresh
// fetch confirms GitHub's data now reflects the mark (next_review is
// genuinely in the future), or after a safety window expires — whichever
// comes first — so this never grows unbounded or gets permanently stuck.
// ---------------------------------------------------------------------------

const RECENTLY_MARKED_STORAGE_KEY = "leetcode_recently_marked";

// Comfortably longer than a realistic GitHub Actions run (typically a few
// seconds to under a minute), short enough to never matter for a problem
// that's genuinely due again on a real future date.
const RECENTLY_MARKED_SAFETY_WINDOW_MS = 10 * 60 * 1000;

function getRecentlyMarked() {
  try {
    const raw = localStorage.getItem(RECENTLY_MARKED_STORAGE_KEY);
    return raw ? JSON.parse(raw) : {};
  } catch (err) {
    return {};
  }
}

function saveRecentlyMarked(map) {
  try {
    localStorage.setItem(RECENTLY_MARKED_STORAGE_KEY, JSON.stringify(map));
  } catch (err) {
    // localStorage can throw in some private-browsing contexts; if so,
    // the override simply won't persist across a reload, which degrades
    // back to the original (rare) race condition rather than crashing.
  }
}

/**
 * Records that a problem was just successfully marked reviewed, so it can
 * survive a page reload even before GitHub's commit has landed.
 */
export function recordRecentlyMarked(problemId) {
  const current = getRecentlyMarked();
  current[problemId] = Date.now();
  saveRecentlyMarked(current);
}

/**
 * Returns a pruned copy of the recently-marked map: drops any entry whose
 * safety window has expired, and drops any entry that fresh reviewsData
 * confirms GitHub has already caught up on (next_review now genuinely in
 * the future). Also writes the pruned result back to localStorage, so the
 * map never grows unbounded across repeated visits.
 */
export function pruneRecentlyMarked(reviewsData, todayStr) {
  const current = getRecentlyMarked();
  const now = Date.now();
  const pruned = {};

  for (const [problemId, markedAt] of Object.entries(current)) {
    const withinWindow = now - markedAt < RECENTLY_MARKED_SAFETY_WINDOW_MS;
    if (!withinWindow) continue;

    const freshEntry = reviewsData[problemId];
    const githubHasCaughtUp = freshEntry && freshEntry.next_review > todayStr;
    if (githubHasCaughtUp) continue;

    pruned[problemId] = markedAt;
  }

  saveRecentlyMarked(pruned);
  return pruned;
}

// ---------------------------------------------------------------------------
// Fetching reviews.json and data.json
// ---------------------------------------------------------------------------

export async function fetchReviewsData() {
  const url = buildRawUrl("stats/reviews.json");
  const res = await fetch(url);
  if (!res.ok) {
    throw new Error(`Failed to fetch reviews.json (HTTP ${res.status})`);
  }
  return res.json();
}

export async function fetchStatsData() {
  const url = buildRawUrl("stats/data.json");
  const res = await fetch(url);
  if (!res.ok) {
    throw new Error(`Failed to fetch data.json (HTTP ${res.status})`);
  }
  return res.json();
}

/**
 * Builds a problem-number -> problem-info index from data.json's nested
 * easy/medium/hard.problems arrays, so any problem can be looked up by its
 * 4-digit id in O(1) rather than scanning three arrays each time.
 */
export function buildProblemIndex(statsData) {
  const index = {};
  for (const difficulty of ["easy", "medium", "hard"]) {
    const bucket = statsData[difficulty];
    if (!bucket || !Array.isArray(bucket.problems)) continue;
    for (const problem of bucket.problems) {
      index[problem.number] = problem;
    }
  }
  return index;
}

// ---------------------------------------------------------------------------
// Due-list computation
// ---------------------------------------------------------------------------

/**
 * Mirrors show_due_reviews() in schedule_review.py: any entry whose
 * next_review is on or before today counts as due, sorted earliest first.
 * todayStr must be in the same 'YYYY-MM-DD' format used throughout reviews.json.
 */
/**
 * Mirrors show_due_reviews() in schedule_review.py: any entry whose
 * next_review is on or before today counts as due, sorted earliest first.
 * todayStr must be in the same 'YYYY-MM-DD' format used throughout reviews.json.
 *
 * recentlyMarked (optional) is the pruned map from pruneRecentlyMarked():
 * any problem id present there is excluded from the due list even if
 * reviewsData still shows it as due, since it was already successfully
 * marked and GitHub's commit just hasn't propagated yet. See the
 * "Recently-marked-reviewed tracking" section above for why this exists.
 */
export function computeDueList(reviewsData, todayStr, recentlyMarked = {}) {
  const due = [];
  for (const [problemId, info] of Object.entries(reviewsData)) {
    if (problemId in recentlyMarked) continue;
    if (info.next_review && info.next_review <= todayStr) {
      due.push({
        id: problemId,
        title: info.title,
        nextReview: info.next_review,
        reviewCount: info.review_count,
      });
    }
  }
  due.sort((a, b) => a.nextReview.localeCompare(b.nextReview));
  return due;
}

export function todayAsString() {
  const now = new Date();
  const yyyy = now.getFullYear();
  const mm = String(now.getMonth() + 1).padStart(2, "0");
  const dd = String(now.getDate()).padStart(2, "0");
  return `${yyyy}-${mm}-${dd}`;
}

// ---------------------------------------------------------------------------
// Fetching a problem's README and solution files
// ---------------------------------------------------------------------------

export async function fetchProblemReadme(problemPath) {
  const url = buildRawUrl(`${problemPath}/README.md`);
  const res = await fetch(url);
  if (!res.ok) {
    throw new Error(`Failed to fetch README.md (HTTP ${res.status})`);
  }
  return res.text();
}

/**
 * Extracts the approach name from a Solution.java file's
 * "// Approach: X" comment line, falling back to a generic label
 * if the line is missing for any reason.
 */
export function parseApproachName(fileContent) {
  const match = fileContent.match(/^\/\/\s*Approach:\s*(.+)$/m);
  return match ? match[1].trim() : "Approach";
}

/**
 * Fetches every SolutionN.java file for a problem, given the known
 * solution count from data.json (no guessing / probing required).
 * Returns an array of { fileName, approachName, code }, in order.
 */
export async function fetchProblemSolutions(problemPath, solutionCount) {
  const fetches = [];
  for (let i = 1; i <= solutionCount; i++) {
    const fileName = `Solution${i}.java`;
    fetches.push(
      fetch(buildRawUrl(`${problemPath}/${fileName}`)).then(async (res) => {
        if (!res.ok) {
          throw new Error(`Failed to fetch ${fileName} (HTTP ${res.status})`);
        }
        const code = await res.text();
        return {
          fileName,
          approachName: parseApproachName(code),
          code,
        };
      })
    );
  }
  return Promise.all(fetches);
}

// ---------------------------------------------------------------------------
// Marking a problem as reviewed (calls the Cloudflare Worker)
// ---------------------------------------------------------------------------

export async function markReviewed(problemId, secret) {
  let res;
  try {
    res = await fetch(WORKER_URL, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "X-Worker-Secret": secret,
      },
      body: JSON.stringify({ problem: problemId }),
    });
  } catch (err) {
    return { ok: false, error: "Could not reach the review server. Check your connection." };
  }

  let body;
  try {
    body = await res.json();
  } catch (err) {
    return { ok: false, error: "Unexpected response from the review server." };
  }

  if (!body.ok) {
    return { ok: false, error: body.error || "Something went wrong marking this reviewed." };
  }

  return { ok: true, problem: body.problem };
}