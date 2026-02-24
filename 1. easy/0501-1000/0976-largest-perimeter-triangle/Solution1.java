import java.util.*;
// LeetCode #0976: Largest Perimeter Triangle
// Approach: Sort
// Status: ✅ Accepted
// Time: O(n log n)  |  Space: O(log n)

class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i+1] > A[i+2])
                return A[i] + A[i+1] + A[i+2];
        return 0;
    }
}