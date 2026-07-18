import { useEffect, useState } from "react";
import {
  fetchProblemReadme,
  fetchProblemSolutions,
  markReviewed,
  getStoredSecret,
  buildRawUrl,
} from "./api.js";

/**
 * Shows a single problem's README and its solutions as tabs (one approach
 * visible at a time), with a Mark Reviewed button at the bottom.
 *
 * problemInfo comes from the index built off data.json: { number, title,
 * path, solutions, ... }. reviewMeta comes from reviews.json for this
 * problem: { review_count, next_review, ... }, used just to show which
 * review number this is.
 */
export default function ProblemView({ problemInfo, reviewMeta, onBack, onMarkedReviewed }) {
  const [readme, setReadme] = useState(null);
  const [solutions, setSolutions] = useState([]);
  const [activeTab, setActiveTab] = useState(0);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const [marking, setMarking] = useState(false);
  const [markError, setMarkError] = useState(null);
  const [marked, setMarked] = useState(false);

  useEffect(() => {
    let cancelled = false;
    setLoading(true);
    setError(null);
    setActiveTab(0);
    setMarked(false);
    setMarkError(null);

    Promise.all([
      fetchProblemReadme(problemInfo.path),
      fetchProblemSolutions(problemInfo.path, problemInfo.solutions),
    ])
      .then(([readmeText, solutionFiles]) => {
        if (cancelled) return;
        setReadme(readmeText);
        setSolutions(solutionFiles);
      })
      .catch((err) => {
        if (cancelled) return;
        setError(err.message);
      })
      .finally(() => {
        if (cancelled) return;
        setLoading(false);
      });

    return () => {
      cancelled = true;
    };
  }, [problemInfo.path, problemInfo.solutions]);

  async function handleMarkReviewed() {
    const secret = getStoredSecret();
    if (!secret) {
      setMarkError("No Worker secret found. Please reload the page.");
      return;
    }
    setMarking(true);
    setMarkError(null);
    const result = await markReviewed(problemInfo.number, secret);
    setMarking(false);
    if (result.ok) {
      setMarked(true);
      onMarkedReviewed(problemInfo.number);
    } else {
      setMarkError(result.error);
    }
  }

  return (
    <div className="problem-view">
      <button className="back-button" onClick={onBack}>
        ← Back to today's review
      </button>

      <h1>
        #{problemInfo.number} — {problemInfo.title}
      </h1>
      {reviewMeta && (
        <p className="review-badge">Review #{reviewMeta.review_count + 1}</p>
      )}

      {loading && <p className="state-message">Loading problem…</p>}
      {error && <p className="state-message error-text">Couldn't load this problem: {error}</p>}

      {!loading && !error && (
        <>
          <section className="readme-section">
            <ReadmeRenderer markdown={readme} problemPath={problemInfo.path} />
          </section>

          <section className="solutions-section">
            <div className="tab-bar">
              {solutions.map((sol, i) => (
                <button
                  key={sol.fileName}
                  className={`tab ${i === activeTab ? "active" : ""}`}
                  onClick={() => setActiveTab(i)}
                >
                  {sol.approachName}
                </button>
              ))}
            </div>
            {solutions[activeTab] && (
              <pre className="code-block">
                <code>{solutions[activeTab].code}</code>
              </pre>
            )}
          </section>

          <section className="mark-reviewed-section">
            {marked ? (
              <p className="success-text">✅ Marked as reviewed. Next review scheduled.</p>
            ) : (
              <>
                <button
                  className="mark-reviewed-button"
                  onClick={handleMarkReviewed}
                  disabled={marking}
                >
                  {marking ? "Marking…" : "Mark as Reviewed"}
                </button>
                {markError && <p className="error-text">{markError}</p>}
              </>
            )}
          </section>
        </>
      )}
    </div>
  );
}

/**
 * Minimal markdown-to-HTML rendering for README content. Handles the
 * subset actually used in these READMEs (headers, bold, code fences,
 * links, and relative-path images) without pulling in a full markdown
 * library dependency.
 */
function ReadmeRenderer({ markdown, problemPath }) {
  if (!markdown) return null;
  const html = renderMarkdown(markdown, problemPath);
  return <div className="readme-content" dangerouslySetInnerHTML={{ __html: html }} />;
}

function renderMarkdown(md, problemPath) {
  let html = escapeHtml(md);

  // Code fences must be extracted BEFORE paragraph splitting and stashed
  // behind placeholders. Otherwise a blank line inside a fenced block
  // (e.g. between "Input:" and "Output:" in these READMEs) gets mistaken
  // for a paragraph break, and a <p> ends up opening in the middle of a
  // <pre><code> block — malformed nesting, confirmed by testing before
  // this fix was in place.
  const codeBlocks = [];
  html = html.replace(/```([\s\S]*?)```/g, (_, code) => {
    const index = codeBlocks.length;
    codeBlocks.push(`<pre><code>${code}</code></pre>`);
    return `\u0000CODEBLOCK${index}\u0000`;
  });

  // Images must be handled BEFORE the plain link regex below — otherwise
  // "![alt](src)" is partially matched by the link pattern, leaving a
  // stray "!" in front of a broken relative-path link. Relative paths
  // like "./1.jpg" are resolved against the problem's own folder, since
  // every image in these READMEs lives alongside its README in the repo,
  // not at the site's root.
  html = html.replace(/!\[([^\]]*)\]\(([^)]+)\)/g, (_, alt, src) => {
    const resolvedSrc = /^https?:\/\//.test(src)
      ? src
      : buildRawUrl(resolveRelativeImagePath(problemPath, src));
    return `<img src="${resolvedSrc}" alt="${alt || "problem illustration"}" loading="lazy" />`;
  });

  // Headers
  html = html.replace(/^### (.*$)/gm, "<h3>$1</h3>");
  html = html.replace(/^## (.*$)/gm, "<h2>$1</h2>");
  html = html.replace(/^# (.*$)/gm, "<h1>$1</h1>");

  // Bold
  html = html.replace(/\*\*(.*?)\*\*/g, "<strong>$1</strong>");

  // Links [text](url) — runs after images, so image syntax is already consumed
  html = html.replace(/\[([^\]]+)\]\(([^)]+)\)/g, '<a href="$2" target="_blank" rel="noopener noreferrer">$1</a>');

  // Horizontal rules
  html = html.replace(/^---$/gm, "<hr />");

  // Line breaks (two trailing spaces = <br>, matching the READMEs' own convention)
  html = html.replace(/  \n/g, "<br />\n");

  // Paragraphs: wrap remaining bare lines, but never wrap a code-block placeholder
  html = html
    .split(/\n{2,}/)
    .map((block) => {
      const trimmed = block.trim();
      if (/^<(h1|h2|h3|hr)/.test(trimmed)) return block;
      if (/^\u0000CODEBLOCK\d+\u0000$/.test(trimmed)) return block;
      return `<p>${block}</p>`;
    })
    .join("\n");

  // Re-insert the real code blocks now that paragraph wrapping is done.
  html = html.replace(/\u0000CODEBLOCK(\d+)\u0000/g, (_, i) => codeBlocks[Number(i)]);

  return html;
}

/**
 * Resolves a relative image path like "./1.jpg" against the problem's
 * own folder path, producing a repo-relative path buildRawUrl can turn
 * into a working URL.
 */
function resolveRelativeImagePath(problemPath, relativePath) {
  const cleaned = relativePath.replace(/^\.\//, "");
  return `${problemPath}/${cleaned}`;
}

function escapeHtml(str) {
  return str
    .replace(/&/g, "&amp;")
    .replace(/</g, "&lt;")
    .replace(/>/g, "&gt;");
}
