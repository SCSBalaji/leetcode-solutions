import java.util.*;
// LeetCode #3498: Reverse Degree of a String
// Approach: Single Pass with Formula
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum+=((26-(s.charAt(i)-'a'))*(i+1));
        }
        return sum;
    }
}