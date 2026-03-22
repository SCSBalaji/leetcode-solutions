import java.util.*;
// LeetCode #2278: Percentage of Letter in String
// Approach: Frequency Array Counting
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int percentageLetter(String s, char letter) {
        int[] chars = new int[26];
        for (char ch : s.toCharArray()) {
            chars[ch - 'a']++;
        }
        return chars[letter - 'a'] * 100 / s.length();
    }
}