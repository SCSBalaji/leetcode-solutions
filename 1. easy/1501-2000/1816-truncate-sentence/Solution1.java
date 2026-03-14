import java.util.*;
// LeetCode #1816: Truncate Sentence
// Approach: Iterative Space Counting
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public String truncateSentence(String s, int k) {
       int count=0;
       for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == ' ') {
                count++;
            }
            if(count==k) {
                return s.substring(0,i);
            }
        }
       return s;
    }
}