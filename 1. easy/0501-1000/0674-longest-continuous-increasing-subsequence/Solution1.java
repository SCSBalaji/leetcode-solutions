import java.util.*;
// LeetCode #0674: Longest Continuous Increasing Subsequence
// Approach: Sliding Window
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }
}