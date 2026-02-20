import java.util.*;
// LeetCode #2367: Number of Arithmetic Triplets
// Approach: Triple Nested Loop Enumeration
// Status: ✅ Accepted
// Time: O(n³)  |  Space: O(1)

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int m = nums.length, cnt = 0;
        for (int i = 0; i < m - 2; i++) {
            int a = nums[i];
            for (int j = i + 1; j < m - 1; j++) {
                int b = nums[j], x = b - a;
                if (x != diff) continue;
                for (int k = j + 1; k < m; k++) {
                    int c = nums[k], y = c - b;
                    if (y == diff) cnt++;
                }
            }
        } 
        return cnt;
    }
}