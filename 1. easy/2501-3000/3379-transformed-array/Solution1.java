import java.util.*;
// LeetCode #3379: Transformed Array
// Approach: Traversal
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(n)

class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[(((i + nums[i]) % n) + n) % n];
        }
        return res;
    }
}