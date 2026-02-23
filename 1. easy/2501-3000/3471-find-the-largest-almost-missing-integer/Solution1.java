import java.util.*;
// LeetCode #3471: Find the Largest Almost Missing Integer
// Approach: Sliding Window with HashMap + HashSet
// Status: ✅ Accepted
// Time: O(n × k)  |  Space: O(n)

class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int i=0; i+k <= nums.length;i++) {
            Set<Integer> seen = new HashSet<>();
            for(int j=i;j<i+k;j++) {
                seen.add(nums[j]);
            }
            for(int n:seen) {
                count.put(n,count.getOrDefault(n,0)+1);
            }
        }
        int ans = -1;
        for(int x:count.keySet()) {
            if(count.get(x)==1) {
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }
}