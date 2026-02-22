import java.util.*;
// LeetCode #0868: Binary Gap
// Approach: Store Indexes in Array
// Status: ✅ Accepted
// Time: O(log n)  |  Space: O(log n)

class Solution {
    public int binaryGap(int N) {
        int[] A = new int[32];
        int t = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) != 0)
                A[t++] = i;
        int ans = 0;
        for (int i = 0; i < t - 1; ++i)
            ans = Math.max(ans, A[i+1] - A[i]);
        return ans;
    }
}