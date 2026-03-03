import java.util.*;
// LeetCode #2810: Faulty Keyboard
// Approach: StringBuilder with Reverse
// Status: ✅ Accepted
// Time: O(n²)  |  Space: O(n)

class Solution {
    public String finalString(String s) {  
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i') {
                sb.reverse();
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString(); 
    }
}