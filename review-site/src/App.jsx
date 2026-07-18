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
} from "./api.js";

export default function App() {
  const [secret, setSecret] = useState(() => getStoredSecret());

  const [reviewsData, setReviewsData] = useState(null);
  const [problemIndex, setProblemIndex] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

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

  const dueList = reviewsData ? computeDueList(reviewsData, todayAsString()) : [];

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
   */
  function handleMarkedReviewed(problemId) {
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
