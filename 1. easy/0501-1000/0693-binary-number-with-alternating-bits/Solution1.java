import java.util.*;
// LeetCode #0693: Binary Number with Alternating Bits
// Approach: Convert to String
// Status: ✅ Accepted
// Time: O(1)  |  Space: O(1)

class Solution {
    public boolean hasAlternatingBits(int n) {
        String bits = Integer.toBinaryString(n);
        for (int i = 0; i < bits.length() - 1; i++) {
            if (bits.charAt(i) == bits.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
}