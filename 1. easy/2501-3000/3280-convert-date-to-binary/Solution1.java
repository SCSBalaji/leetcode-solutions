import java.util.*;
// LeetCode #3280: Convert Date to Binary
// Approach: Split, Convert, Rebuild
// Status: ✅ Accepted
// Time: O(1)  |  Space: O(1)

class Solution {
    public String convertDateToBinary(String date) {
        String [] parts = date.split("-");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<parts.length;i++)
        {
            int num = Integer.parseInt(parts[i]);
            sb.append(Integer.toBinaryString(num));
            if(i != parts.length-1)
            {
                sb.append("-");
            }
        }
        return sb.toString();
    }
}