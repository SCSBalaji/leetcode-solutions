import java.util.*;
// LeetCode #1009: Complement of Base 10 Integer
// Approach: Binary String Flip
// Status: ✅ Accepted
// Time: O(log n)  |  Space: O(log n)

class Solution {
    public int bitwiseComplement(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for(char ch : binary.toCharArray()) {
            if(ch == '1') {
                sb.append('0');
            }
            else {
                sb.append('1');
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}