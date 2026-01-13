import java.util.*;
// LeetCode #1929: Concatenation of Array
// Approach: Simple Iteration
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(n)

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int [] res = new int[2 * n];
        for(int i = 0; i < n; i++) {
            res[i] = nums[i];
            res[i + n] = nums[i];
        }
        return res;
    }
}