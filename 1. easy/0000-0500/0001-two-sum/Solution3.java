// LeetCode #0001: Two Sum
// Approach: Two Pass Hash Table
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if(map.containsKey(result) && map.get(result) != i) {
                return new int[] {i, map.get(result)};
            }
        }
        return new int[] {};
    }
}