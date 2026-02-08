import java.util.*;
// LeetCode #2894: Divisible And Non Divisible Sums Difference
// Approach: Mathematical Derivation
// Status: ✅ Accepted
// Time: O(1)  |  Space: O(1)

class Solution {
    public int differenceOfSums(int n, int m) {
        int k = n / m;
        return (n * (n + 1)) / 2 - k * (k + 1) * m;
    }
}