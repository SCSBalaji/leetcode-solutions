import java.util.*;
// LeetCode #3512: Minimum Operations to Make Array Sum Divisible by K
// Approach: Sum Modulo
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;
    }
}