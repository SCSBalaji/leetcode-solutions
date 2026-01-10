import java.util.*;
// LeetCode #0001: Two Sum
// Approach: Brute Force
// Status: ✅ Accepted
// Time: O(n^2)  |  Space: O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] { i, j};
                }
            }
        }
        return new int[] {};
    }
}