import java.util.*;
// LeetCode #1689: Partitioning Into Minimum Number Of Deci-Binary Numbers
// Approach: Find Maximum Digit
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int minPartitions(String n) {
        int maxi=0;
        for(int i=0; i<n.length(); i++){
            int dig=n.charAt(i)-'0';
            maxi=Math.max(maxi,dig);
        }
        return maxi;
    }
}