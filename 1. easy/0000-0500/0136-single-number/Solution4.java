import java.util.*;
// LeetCode #0136: Single Number
// Approach: Bit Manipulation
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for(int i : nums) {
            a ^= i;
        }
        return a;
    }
}