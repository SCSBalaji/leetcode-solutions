import java.util.*;
// LeetCode #2942: Find Words Containing Character
// Approach: Simulation
// Status: ✅ Accepted
// Time: O(n * m)  |  Space: O(1)

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        int n = words.length;
        for(int i = 0; i < n; i++) {
            if(words[i].indexOf(x) != -1) {
                list.add(i);
            }
        }
        return list;
    }
}