import java.util.*;
// LeetCode #3315: Construct the Minimum Bitwise Array II
// Approach: Bitwise Operation
// Status: ✅ Accepted
// Time: O(n log m)  |  Space: O(1)

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            int res = -1;
            int d = 1;
            while ((x & d) != 0) {
                res = x - d;
                d <<= 1;
            }
            result[i] = res;
        }
        return result;
    }
}