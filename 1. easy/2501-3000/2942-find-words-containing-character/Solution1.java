import java.util.*;
// LeetCode #2942: Find Words Containing Character
// Approach: Brute Force
// Status: ✅ Accepted
// Time: O(n * m)  |  Space: O(k)

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                if(words[i].charAt(j) == x) {
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}