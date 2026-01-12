import java.util.*;
// LeetCode #0136: Single Number
// Approach: Hash Table
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(n)

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hash_map = new HashMap<>();
        for(int i : nums) {
            hash_map.put(i, hash_map.getOrDefault(i, 0) + 1);
        }
        for(int i : nums) {
            if(hash_map.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }
}