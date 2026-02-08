import java.util.*;
// LeetCode #2894: Divisible and Non-divisible Sums Difference
// Approach: Traversal
// Status: ✅ Accepted
// Time: O()  |  Space: O()

class Solution {
    public int differenceOfSums(int n, int m) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                ans -= i;
            } else {
                ans += i;
            }
        }
        return ans;
    }
}