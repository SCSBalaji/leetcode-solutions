import java.util.*;
// LeetCode #3110: Score of a String
// Approach: Linear Iteration
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }
}