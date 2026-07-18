import { useEffect, useState } from "react";
import SecretPrompt from "./SecretPrompt.jsx";
import ReviewList from "./ReviewList.jsx";
import ProblemView from "./ProblemView.jsx";
import {
  getStoredSecret,
  fetchReviewsData,
  fetchStatsData,
  buildProblemIndex,
  computeDueList,
  todayAsString,
  pruneRecentlyMarked,
  recordRecentlyMarked,
} from "./api.js";

export default function App() {
  const [secret, setSecret] = useState(() => getStoredSecret());

  const [reviewsData, setReviewsData] = useState(null);
  const [problemIndex, setProblemIndex] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // Pruned recently-marked-reviewed overrides — see api.js for why this
  // exists. Recomputed every time fresh reviewsData is fetched, since a
  // fresh fetch is exactly the moment we can check whether GitHub's data
  // has finally caught up on any pending mark.
  const [recentlyMarked, setRecentlyMarked] = useState({});

  const [selectedProblemId, setSelectedProblemId] = useState(null);

  // Load reviews.json + data.json once the secret is available.
  // (Loading doesn't strictly need the secret — reading is unauthenticated —
  // but there's no reason to show the review list before setup is done.)
  useEffect(() => {
    if (!secret) return;

    let cancelled = false;
    setLoading(true);
    setError(null);

    Promise.all([fetchReviewsData(), fetchStatsData()])
      .then(([reviews, stats]) => {
        if (cancelled) return;
        setReviewsData(reviews);
        setProblemIndex(buildProblemIndex(stats));
        // Reconcile the local override against this freshly-fetched data
        // right away — this is the step that fixes the reload race: even
        // if `reviews` here is stale (GitHub's commit hasn't landed yet),
        // the previously-recorded override survives in localStorage and
        // gets applied below, so the just-marked problem stays hidden
        // instead of reappearing as due.
        setRecentlyMarked(pruneRecentlyMarked(reviews, todayAsString()));
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
  }, [secret]);

  if (!secret) {
    return <SecretPrompt onSaved={setSecret} />;
  }

  const dueList = reviewsData
    ? computeDueList(reviewsData, todayAsString(), recentlyMarked)
    : [];

  function handleSelectProblem(problemId) {
    setSelectedProblemId(problemId);
  }

  function handleBack() {
    setSelectedProblemId(null);
  }

  /**
   * Optimistic UI update: once the Worker confirms a mark-reviewed call
   * succeeded, remove that problem from the in-memory reviewsData so it
   * immediately disappears from today's due list — without needing to
   * re-fetch reviews.json (which wouldn't reflect the change yet anyway,
   * since the commit takes a few seconds to land on GitHub after the
   * Worker call returns).
   *
   * Also records the mark in localStorage via recordRecentlyMarked, so
   * this survives a page reload — not just the in-memory state update
   * above. Without this half, a reload right after marking (before
   * GitHub's commit has actually landed) would re-fetch stale data that
   * still shows the problem as due, causing it to reappear and risking
   * a genuine double mark on GitHub. See api.js for the full explanation.
   */
  function handleMarkedReviewed(problemId) {
    recordRecentlyMarked(problemId);
    setRecentlyMarked((prev) => ({ ...prev, [problemId]: Date.now() }));
    setReviewsData((prev) => {
      if (!prev || !prev[problemId]) return prev;
      const updated = { ...prev };
      delete updated[problemId];
      return updated;
    });
  }

  if (selectedProblemId) {
    const problemInfo = problemIndex?.[selectedProblemId];
    const reviewMeta = reviewsData?.[selectedProblemId];

    if (!problemInfo) {
      return (
        <div className="state-message error-text">
          Problem #{selectedProblemId} isn't in the current stats data.
          <button onClick={handleBack}>← Back</button>
        </div>
      );
    }

    return (
      <ProblemView
        problemInfo={problemInfo}
        reviewMeta={reviewMeta}
        onBack={handleBack}
        onMarkedReviewed={handleMarkedReviewed}
      />
    );
  }

  return (
    <ReviewList
      dueList={dueList}
      onSelectProblem={handleSelectProblem}
      loading={loading}
      error={error}
    />
  );
}
