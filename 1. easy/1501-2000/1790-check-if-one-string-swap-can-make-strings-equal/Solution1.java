import java.util.*;
// LeetCode #1790: Check if One String Swap Can Make Strings Equal
// Approach: Difference Index Tracking
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int firstIndexDiff = 0;
        int secondIndexDiff = 0;
        int numDiffs = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                numDiffs++;
                if (numDiffs > 2) return false;
                else if (numDiffs == 1) {
                    firstIndexDiff = i;
                } else {
                    secondIndexDiff = i;
                }
            }
        }
        return (s1.charAt(firstIndexDiff) == s2.charAt(secondIndexDiff) && s1.charAt(secondIndexDiff) == s2.charAt(firstIndexDiff));
    }
}