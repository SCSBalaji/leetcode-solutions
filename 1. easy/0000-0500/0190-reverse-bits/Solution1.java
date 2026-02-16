import java.util.*;
// LeetCode #0190: Reverse Bits
// Approach: Bit-by-Bit Reversal with Shift Operations
// Status: ✅ Accepted
// Time: O(1)  |  Space: O(1)

class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for(int i=0; i<32;i++){
            result<<=1;
            result |= (n&1);
            n>>>=1; 
        }
        return result;
    }
}