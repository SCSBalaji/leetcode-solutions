import java.util.*;
// LeetCode #2243: Calculate Digit Sum of a String
// Approach: Iterative Group Simulation
// Status: ✅ Accepted
// Time: O(n²)  |  Space: O(n)

class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k){
            String str ="";
            int n = s.length();
            int i = 0;
            while( i < n){
                int num =0;
                int x = k;
                while(x > 0 && i < n){
                    num+=Integer.parseInt(String.valueOf(s.charAt(i)));
                    i++;
                    x--;
                }
                str+=Integer.toString(num);
            }
            s = str;
        }
        return s;
    }
}