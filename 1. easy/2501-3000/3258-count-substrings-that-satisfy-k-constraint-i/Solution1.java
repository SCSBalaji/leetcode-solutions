import java.util.*;
// LeetCode #3258: Count Substrings That Satisfy K-Constraint I
// Approach: Sliding Window with Invalid Counting
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int left = 0, invalid = 0, ones = 0, zeros = 0;
        int n = s.length();
        long total = (long) n * (n + 1) / 2;
        for(int right = 0; right < s.length(); right ++) {
            if(s.charAt(right) == '1') {
                ones ++;
            }else {
                zeros ++;
            }
            while(zeros > k && ones > k) {
                invalid+= n - right;
                if(s.charAt(left) == '1') {
                    ones --;
                }else {
                    zeros --;
                }
                left++;
            }
        }
        return (int)total - invalid;
    }
}