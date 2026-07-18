import { useState } from "react";
import { storeSecret } from "./api.js";

/**
 * Shown once, before anything else, if no secret is found in localStorage.
 * The secret is never hardcoded into the app's source — it only exists in
 * this input field and then in the browser's own localStorage.
 */
export default function SecretPrompt({ onSaved }) {
  const [value, setValue] = useState("");
  const [touched, setTouched] = useState(false);

  const isValid = value.trim().length > 0;

  function handleSubmit(e) {
    e.preventDefault();
    setTouched(true);
    if (!isValid) return;
    storeSecret(value.trim());
    onSaved(value.trim());
  }

  return (
    <div className="secret-prompt">
      <div className="secret-prompt-card">
        <h1>Review Site Setup</h1>
        <p>
          Enter your Worker secret once. It's saved only in this browser's
          local storage — never sent anywhere except to your Cloudflare
          Worker when you mark a problem reviewed.
        </p>
        <form onSubmit={handleSubmit}>
          <input
            type="password"
            value={value}
            onChange={(e) => setValue(e.target.value)}
            placeholder="Worker secret"
            autoFocus
          />
          {touched && !isValid && (
            <p className="error-text">Secret can't be empty.</p>
          )}
          <button type="submit">Save and continue</button>
        </form>
      </div>
    </div>
  );
}
