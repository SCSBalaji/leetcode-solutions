import java.util.*;
// LeetCode #3643: Flip Square Submatrix Vertically
// Approach: Simulation
// Status: ✅ Accepted
// Time: O(k^2)  |  Space: O(1)

class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i0 = x, i1 = x + k - 1; i0 < i1; i0++, i1--) {
            for (int j = y; j < y + k; j++) {
                int temp = grid[i0][j];
                grid[i0][j] = grid[i1][j];
                grid[i1][j] = temp;
            }
        }
        return grid;
    }
}