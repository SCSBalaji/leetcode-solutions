import java.util.*;
// LeetCode #1128: Number of Equivalent Domino Pairs
// Approach: Canonical Encoding + Frequency Count
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1]
                ? domino[0] * 10 + domino[1]
                : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }
}