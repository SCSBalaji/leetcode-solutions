import java.util.*;
// LeetCode #1784: Check if Binary String Has at Most One Segment of Ones
// Approach: Pattern Detection
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(1)

class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}