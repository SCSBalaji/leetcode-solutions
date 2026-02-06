import java.util.*;
// LeetCode #3634: Minimum Removals to Balance Array
// Approach: Sorting + Two Pointers
// Status: ✅ Accepted
// Time: O(n log n)  |  Space: O(log n)

class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = n;
        int right = 0;
        for (int left = 0; left < n; left++) {
            while (right < n && nums[right] <= (long) nums[left] * k) {
                right++;
            }
            ans = Math.min(ans, n - (right - left));
        }
        return ans;
    }
}