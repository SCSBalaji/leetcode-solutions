import java.util.*;
// LeetCode #1052: Grumpy Bookstore Owner
// Approach: Sliding Window
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int unsatisfied = 0;
        for(int i = 0; i < minutes; i++) {
            unsatisfied += customers[i] * grumpy[i];
        }
        int maxi = unsatisfied;
        for(int i = minutes; i < n; i++) {
            unsatisfied += customers[i] * grumpy[i];
            unsatisfied -= customers[i - minutes] * grumpy[i - minutes];
            maxi = Math.max(maxi, unsatisfied);
        }
        int total = maxi;
        for(int i = 0; i < n; i++) {
            total += customers[i] * (1 - grumpy[i]);
        }
        return total;
    }
}