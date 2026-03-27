import java.util.*;
// LeetCode #2946: Matrix Similarity After Cyclic Shifts
// Approach: Modulo Shift Invariance Check
// Status: ✅ Accepted
// Time: O(m * n)  |  Space: O(1)

class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        k %= n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != mat[i][(j + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
}