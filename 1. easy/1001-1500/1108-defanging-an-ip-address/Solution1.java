import java.util.*;
// LeetCode #1108: Defanging an IP Address
// Approach: Iterative
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(n)

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder result = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                result.append("[.]");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}