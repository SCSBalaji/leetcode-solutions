import java.util.*;
// LeetCode #3668: Restore Finishing Order
// Approach: Brute Force
// Status: ✅ Accepted
// Time: O(n * m)  |  Space: O(m)

class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int [] res = new int[friends.length];
        int index = 0;
        for (int i = 0; i < order.length; i++){
            for (int j = 0; j < friends.length; j++){
                if (order[i] == friends[j]){
                    res[index++] = order[i];
                    break;
                }
            }
        }
        return res;
    }
}