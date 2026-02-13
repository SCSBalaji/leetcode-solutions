import java.util.*;
// LeetCode #1365: How Many Numbers Are Smaller Than the Current Number
// Approach: Brute Force
// Status: ✅ Accepted
// Time: O(n²)  |  Space: O(n)

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i=0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    result[i] += 1;
                }
            }
        }
        return result;
    }
}