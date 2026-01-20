import java.util.*;
// LeetCode #1920: Build Array From Permutation
// Approach: Build In Place
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            nums[i] += 1000 * (nums[nums[i]] % 1000);
        }
        for (int i = 0; i < n; ++i) {
            nums[i] /= 1000;
        }
        return nums;
    }
}