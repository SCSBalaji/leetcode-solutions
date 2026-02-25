import java.util.*;
// LeetCode #1528: Shuffle String
// Approach: Index Mapping with Array
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(n)

class Solution {
    public String restoreString(String s, int[] indices) {
        String[] arr=new String[s.length()];
        for(int i=0;i<indices.length;i++){
            arr[indices[i]]=String.valueOf(s.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();    
    }
}