import java.util.*;
// LeetCode #0693: Binary Number With Alternating Bits
// Approach: Divide By Two
// Status: ✅ Accepted
// Time: O(1)  |  Space: O(1)

class Solution {
    public boolean hasAlternatingBits(int n) {
        int cur = n % 2;
        n /= 2;
        while (n > 0) {
            if (cur == n % 2) return false;
            cur = n % 2;
            n /= 2;
        }
        return true;
    }
}