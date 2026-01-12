import java.util.*;
// LeetCode #0136: Single Number
// Approach: List Operation
// Status: ✅ Accepted
// Time: O(n^2)  |  Space: O(n)

class Solution {
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i : nums) {
            if(!list.contains(i)) {
                list.add(i);
            }
            else {
                list.remove(Integer.valueOf(i));
            }
        }
        return list.get(0);
    }
}