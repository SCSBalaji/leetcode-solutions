import java.util.*;
// LeetCode #1769: Minimum Number Of Operations To Move All Balls To Each Box
// Approach: Sum Of Left And Right Moves
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        int ballsToLeft = 0, movesToLeft = 0;
        int ballsToRight = 0, movesToRight = 0;
        for (int i = 0; i < n; i++) {
            answer[i] += movesToLeft;
            ballsToLeft += Character.getNumericValue(boxes.charAt(i));
            movesToLeft += ballsToLeft;
            int j = n - 1 - i;
            answer[j] += movesToRight;
            ballsToRight += Character.getNumericValue(boxes.charAt(j));
            movesToRight += ballsToRight;
        }
        return answer;
    }
}