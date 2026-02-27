import java.util.*;
// LeetCode #1935: Maximum Number of Words You Can Type
// Approach: Traversal + Hash Set
// Status: ✅ Accepted
// Time: O(n + m)  |  Space: O(m)

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> broken = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) {
            broken.add(ch);
        }
        int res = 0;
        boolean flag = true;
        for (char ch : text.toCharArray()) {
            if (ch == ' ') {
                if (flag) {
                    ++res;
                }
                flag = true;
            } else if (broken.contains(ch)) {
                flag = false;
            }
        }
        if (flag) {
            ++res;
        }
        return res;
    }
}