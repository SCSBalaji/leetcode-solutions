/**
 * Cloudflare Worker: mark-review proxy
 *
 * Sits between the public review website and GitHub's repository_dispatch
 * API. Its only job is to hold the GitHub token somewhere the browser can
 * never read, validate the incoming request, and forward a dispatch call
 * identical to the curl command already tested manually:
 *
 *   curl -X POST \
 *     -H "Authorization: token $GITHUB_TOKEN" \
 *     -H "Accept: application/vnd.github+json" \
 *     https://api.github.com/repos/OWNER/REPO/dispatches \
 *     -d '{"event_type":"mark-review","client_payload":{"problem":"3954"}}'
 *
 * Secrets required (set via `wrangler secret put <NAME>`):
 *   GITHUB_TOKEN   - the fine-grained PAT with Contents: Read and write
 *                    on the leetcode-solutions repo
 *   WORKER_SECRET  - a random string only the frontend knows, checked
 *                    against the X-Worker-Secret header on every request
 *
 * Config required (set as plain vars in wrangler.toml, not secret):
 *   GITHUB_OWNER    - e.g. "scsbalaji"
 *   GITHUB_REPO     - e.g. "leetcode-solutions"
 *   ALLOWED_ORIGINS - comma-separated list of origins the frontend may run
 *                     on, e.g. "http://localhost:5173,https://yourdomain.com"
 *                     CORS requires the response to echo back the exact
 *                     requesting origin, not a fixed string — so this
 *                     Worker checks the incoming request's Origin header
 *                     against this list and only reflects it back on a
 *                     match. A single hardcoded origin would work for one
 *                     environment (e.g. only the deployed site) but breaks
 *                     local dev against localhost, which is why this is a
 *                     list rather than one value.
 */

// A problem number should be 1-4 digits before zero-padding, matching the
// same format used everywhere else in the repo (folder prefixes, reviews.json
// keys, paths.json keys all end up as 4-digit zero-padded strings).
const PROBLEM_NUMBER_PATTERN = /^[0-9]{1,4}$/;

/**
 * CORS requires the Access-Control-Allow-Origin response header to exactly
 * match the requesting browser's origin — it can't be a wildcard alongside
 * credentials, and it can't just be "whatever we configured" if more than
 * one real origin needs to work (local dev + the deployed site).
 *
 * This checks the request's actual Origin header against the comma-separated
 * ALLOWED_ORIGINS list from config, and returns the exact matching entry to
 * reflect back — or null if the requesting origin isn't on the list, in
 * which case no CORS header is set and the browser will correctly refuse
 * the response.
 */
function resolveAllowedOrigin(request, env) {
  const requestOrigin = request.headers.get("Origin");
  if (!requestOrigin) return null;

  const allowed = (env.ALLOWED_ORIGINS || "")
    .split(",")
    .map((o) => o.trim())
    .filter(Boolean);

  return allowed.includes(requestOrigin) ? requestOrigin : null;
}

function corsHeaders(origin) {
  if (!origin) return {};
  return {
    "Access-Control-Allow-Origin": origin,
    "Access-Control-Allow-Methods": "POST, OPTIONS",
    "Access-Control-Allow-Headers": "Content-Type, X-Worker-Secret",
  };
}

function jsonResponse(body, status, origin) {
  return new Response(JSON.stringify(body), {
    status,
    headers: {
      "Content-Type": "application/json",
      ...corsHeaders(origin),
    },
  });
}

export default {
  async fetch(request, env) {
    const origin = resolveAllowedOrigin(request, env);

    // Browsers send a CORS preflight OPTIONS request before the real POST.
    // Must be answered directly, before any auth or body parsing.
    if (request.method === "OPTIONS") {
      return new Response(null, { status: 204, headers: corsHeaders(origin) });
    }

    if (request.method !== "POST") {
      return jsonResponse({ ok: false, error: "Method not allowed" }, 405, origin);
    }

    // Shared-secret check. This isn't meant to be bulletproof security —
    // it's meant to stop a random person who finds the Worker's public URL
    // from being able to trigger dispatches on the repo. The real secret
    // (the GitHub token) never leaves this Worker either way.
    const providedSecret = request.headers.get("X-Worker-Secret");
    if (!providedSecret || providedSecret !== env.WORKER_SECRET) {
      return jsonResponse({ ok: false, error: "Unauthorized" }, 401, origin);
    }

    let body;
    try {
      body = await request.json();
    } catch (err) {
      return jsonResponse({ ok: false, error: "Invalid JSON body" }, 400, origin);
    }

    const problem = body && body.problem;
    if (!problem || typeof problem !== "string" || !PROBLEM_NUMBER_PATTERN.test(problem)) {
      return jsonResponse(
        { ok: false, error: "Missing or invalid 'problem' field (expected 1-4 digits)" },
        400,
        origin
      );
    }

    const dispatchUrl = `https://api.github.com/repos/${env.GITHUB_OWNER}/${env.GITHUB_REPO}/dispatches`;

    let githubResponse;
    try {
      githubResponse = await fetch(dispatchUrl, {
        method: "POST",
        headers: {
          Authorization: `token ${env.GITHUB_TOKEN}`,
          Accept: "application/vnd.github+json",
          "Content-Type": "application/json",
          // GitHub requires a User-Agent on API requests.
          "User-Agent": "leetcode-review-worker",
        },
        body: JSON.stringify({
          event_type: "mark-review",
          client_payload: { problem },
        }),
      });
    } catch (err) {
      return jsonResponse({ ok: false, error: "Failed to reach GitHub API" }, 502, origin);
    }

    // GitHub returns 204 No Content on success with an empty body.
    // Anything else (401, 404, 422, etc.) means something is wrong with
    // the token, repo path, or payload shape.
    if (githubResponse.status === 204) {
      return jsonResponse({ ok: true, problem }, 200, origin);
    }

    let githubErrorText = "";
    try {
      githubErrorText = await githubResponse.text();
    } catch (err) {
      // ignore, fall through with empty error text
    }

    return jsonResponse(
      {
        ok: false,
        error: "GitHub dispatch failed",
        status: githubResponse.status,
        detail: githubErrorText,
      },
      502,
      origin
    );
  },
};