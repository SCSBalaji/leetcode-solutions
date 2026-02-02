import java.util.*;
// LeetCode #3467: Transform Array by Parity
// Approach: Modulo + Sort
// Status: ✅ Accepted
// Time: O(n log n)  |  Space: O(n)

class Solution {
    public int[] transformArray(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++) {
            nums[i]=nums[i]%2;
        }
        Arrays.sort(nums);
        return nums;
        
    }
}