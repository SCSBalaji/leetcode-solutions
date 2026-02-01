import java.util.*;
// LeetCode #3010: Divide an Array Into Subarrays With Minimum Cost I
// Approach: Greedy
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int minimumCost(int[] nums) {
        int m1=Integer.MAX_VALUE;
        int m2=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]<m1) {
                m2=m1;
                m1=nums[i];
            }
            else if(nums[i]<m2) {
                m2=nums[i];
            }
        }
        return nums[0]+m1+m2;
    }
}