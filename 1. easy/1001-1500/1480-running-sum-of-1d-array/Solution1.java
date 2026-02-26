import java.util.*;
// LeetCode #1480: Running Sum of 1d Array
// Approach: Prefix Sum
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(n)

class Solution {
    public int[] runningSum(int[] nums) {
        int runningSum[]=new int[nums.length];
        runningSum[0]=nums[0];
        for(int i=1;i<nums.length;i++) {
            runningSum[i]=runningSum[i-1]+nums[i];
        }
        return runningSum;
    }
}