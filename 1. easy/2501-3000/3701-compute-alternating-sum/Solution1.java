import java.util.*;
// LeetCode #3701: Compute Alternating Sum
// Approach: Iterative Index Parity
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int alternatingSum(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                res += nums[i];
            } else {
                res -= nums[i];
            }
        }
        return res;
    }
}