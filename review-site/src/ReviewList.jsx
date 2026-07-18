/**
 * Today's Review — the home view. Shows every problem currently due,
 * sorted earliest-due first, each showing which review number this is
 * (matching the "Review #N" phrasing already used in the email/Telegram
 * reminders, so the numbering feels consistent with what's familiar).
 */
export default function ReviewList({ dueList, onSelectProblem, loading, error }) {
  if (loading) {
    return <div className="state-message">Loading today's reviews…</div>;
  }

  if (error) {
    return (
      <div className="state-message error-text">
        Couldn't load your review list: {error}
      </div>
    );
  }

  if (dueList.length === 0) {
    return (
      <div className="state-message">
        🎉 No problems due for review today.
      </div>
    );
  }

  return (
    <div className="review-list">
      <h1>Today's Review</h1>
      <p className="due-count">{dueList.length} problem{dueList.length === 1 ? "" : "s"} due</p>
      <ul>
        {dueList.map((problem) => (
          <li key={problem.id}>
            <button
              className="review-list-item"
              onClick={() => onSelectProblem(problem.id)}
            >
              <span className="problem-number">#{problem.id}</span>
              <span className="problem-title">{problem.title}</span>
              <span className="review-badge">Review #{problem.reviewCount + 1}</span>
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}
