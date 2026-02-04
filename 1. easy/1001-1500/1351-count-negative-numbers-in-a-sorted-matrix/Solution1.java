import java.util.*;
// LeetCode #1351: Count Negative Numbers in a Sorted Matrix
// Approach: Staircase Search (Top-Right to Bottom-Left)
// Status: ✅ Accepted
// Time: O(m + n)  |  Space: O(1)

class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int r = 0;
        int c = cols - 1;
        int count = 0;
        while (r < rows && c >= 0) {
            if (grid[r][c] < 0) {
                count += (rows - r);
                c--;
            } else {
                r++;
            }
        }
        return count;
    }
}