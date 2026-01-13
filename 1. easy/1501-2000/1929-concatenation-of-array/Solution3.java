import java.util.*;
// LeetCode #1929: Concatenation Of Array
// Approach: CopyOf with Built-In Array Copy
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(n)

class Solution {
    public int[] getConcatenation(int[] a) {
        int[] b = Arrays.copyOf(a, 2 * a.length);
        System.arraycopy(a, 0, b, a.length, a.length);
        return b;
    }
}