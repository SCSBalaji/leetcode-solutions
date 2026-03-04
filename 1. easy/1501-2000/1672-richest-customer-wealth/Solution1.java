import java.util.*;
// LeetCode #1672: Richest Customer Wealth
// Approach: Row Sum
// Status: ✅ Accepted
// Time: O(m × n)  |  Space: O(1)

class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxwealth = 0;
        for(int i=0;i<accounts.length;i++){
        int sum=0;
            for(int j = 0;j<accounts[i].length;j++){
                sum +=accounts[i][j];
            }
            int wealth = sum;
            maxwealth = Math.max(maxwealth, wealth);
        }
        return maxwealth;
    }
}