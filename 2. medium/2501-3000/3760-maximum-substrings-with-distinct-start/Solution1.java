import java.util.*;
// LeetCode #3760: Maximum Substrings With Distinct Start
// Approach: Hash Set
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public int maxDistinct(String s) {
       HashSet<Character> hs=new HashSet<>();
       int n=s.length();
       for(int i=0;i<n;i++){
        hs.add(s.charAt(i));
       }
       return hs.size();
    }
}