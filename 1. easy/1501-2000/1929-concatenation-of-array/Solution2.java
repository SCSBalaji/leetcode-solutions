import java.util.*;
// LeetCode #1929: Concatenation Of Array
// Approach: Built-In Array Copy
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(n)

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int [] res = new int[2 * n];
        
        System.arraycopy(nums, 0, res, 0 , n);
        System.arraycopy(nums, 0, res, n , n);
        return res;
    }
}