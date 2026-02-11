import java.util.*;
// LeetCode #3304: Find the K-th Character in String Game I
// Approach: Iteration
// Status: ✅ Accepted
// Time: O(log k)  |  Space: O(1)

class Solution {
    public char kthCharacter(int k) {
        int ans = 0;
        int t;
        while (k != 1) {
            t = 31 - Integer.numberOfLeadingZeros(k);
            if ((1 << t) == k) {
                t--;
            }
            k = k - (1 << t);
            ans++;
        }
        return (char) ('a' + ans);
    }
}