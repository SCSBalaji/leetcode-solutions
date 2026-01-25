import java.util.*;
// LeetCode #1984: Minimum Difference Between Highest and Lowest of K Scores
// Approach: Sorting
// Status: ✅ Accepted
// Time: O(n log n)  |  Space: O(log n)

class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < n; ++i) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }
}