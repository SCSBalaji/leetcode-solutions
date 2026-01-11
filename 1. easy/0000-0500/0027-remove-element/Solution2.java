import java.util.*;
// LeetCode #0027: Remove Element
// Approach: Two Pointers (Swap to End)
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while(i < n) {
            if(nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } 
            else {
                i++;
            }
        }
        return n;
    }
}