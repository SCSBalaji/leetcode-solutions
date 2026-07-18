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
export function computeDueList(reviewsData, todayStr) {
  const due = [];
  for (const [problemId, info] of Object.entries(reviewsData)) {
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
