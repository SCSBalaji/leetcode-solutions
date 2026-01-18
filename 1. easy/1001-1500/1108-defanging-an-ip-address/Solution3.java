import java.util.*;
// LeetCode #1108: Defanging An Ip Address
// Approach: Regular Expression
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(n)

class Solution {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}