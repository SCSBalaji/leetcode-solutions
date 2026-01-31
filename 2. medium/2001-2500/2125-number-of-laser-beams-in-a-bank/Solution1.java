import java.util.*;
// LeetCode #2125: Number of Laser Beams in a Bank
// Approach: Greedy
// Status: ✅ Accepted
// Time: O(m * n)  |  Space: O(1)

class Solution {
  public int numberOfBeams(String[] bank) {
    int prev = 0, ans = 0;
    for (String s: bank) {
      int count = 0;
      for (int i = 0; i < s.length(); i++)
        if (s.charAt(i) == '1') {
          count++;
        }
      if (count > 0) {
        ans += prev * count;
        prev = count;
      }
    }
    return ans;
  }
}