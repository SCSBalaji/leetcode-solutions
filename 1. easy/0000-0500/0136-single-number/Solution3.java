import java.util.*;
// LeetCode #0136: Single Number
// Approach: Math
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(n)

class Solution {
    public int singleNumber(int[] nums) {
        int sumOfUnique = 0, sumOfAll = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            if(!set.contains(i)) {
                set.add(i);
                sumOfUnique += i;
            }
            sumOfAll += i;
        }
        return 2 * sumOfUnique - sumOfAll;
    }
}