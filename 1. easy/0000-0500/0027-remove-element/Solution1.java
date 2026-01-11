import java.util.*;
// LeetCode #0027: Remove Element
// Approach: Two Pointers
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}