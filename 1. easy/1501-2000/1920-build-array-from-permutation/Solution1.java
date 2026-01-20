import java.util.*;
// LeetCode #1920: Build Array from Permutation
// Approach: Build As Required
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}