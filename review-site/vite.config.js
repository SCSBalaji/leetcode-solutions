import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// base: "/" is correct here because the site will be served from the root
// of a custom subdomain (review.yourdomain.com), not from a github.io
// subpath like username.github.io/leetcode-solutions/. If this were ever
// hosted at a subpath instead, this would need to change to match it
// (e.g. "/leetcode-solutions/"), or every asset URL in the built output
// would resolve incorrectly.
export default defineConfig({
  plugins: [react()],
  base: "/",
});