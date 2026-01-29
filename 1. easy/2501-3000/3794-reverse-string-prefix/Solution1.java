import java.util.*;
// LeetCode #3794: Reverse String Prefix
// Approach: String Concatenation
// Status: ✅ Accepted
// Time: O(n²)  |  Space: O(n)

class Solution {
    public String reversePrefix(String s, int k) {
        String str="";
        for(int i=k-1;i>=0;i--){
            str+=s.charAt(i);
        }
        for(int i=k;i<s.length();i++){
            str+=s.charAt(i);
        }
        return str;
    }
}