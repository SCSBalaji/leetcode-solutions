# [3567]. Minimum Absolute Difference in Sliding Submatrix

**Difficulty:** Medium  
**Topics:** `Array`, `Sorting`, `Matrix`  
**Companies:** N/A  
**Link:** [Minimum Absolute Difference in Sliding Submatrix](https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/)

---

## Problem Statement

You are given an m x n integer matrix grid and an integer k.

For every contiguous k x k submatrix of grid, compute the minimum absolute difference between any two distinct values within that submatrix.

Return a 2D array ans of size (m - k + 1) x (n - k + 1), where ans[i][j] is the minimum absolute difference in the submatrix whose top-left corner is (i, j) in grid.

Note: If all elements in the submatrix have the same value, the answer will be 0.

A submatrix (x1, y1, x2, y2) is a matrix that is formed by choosing all cells matrix[x][y] where x1 <= x <= x2 and y1 <= y <= y2.

**Example 1:**
```
Input: grid = [[1,8],[3,-2]], k = 2

Output: [[2]]

Explanation:

- There is only one possible k x k submatrix: [[1, 8], [3, -2]].
- Distinct values in the submatrix are [1, 8, 3, -2].
- The minimum absolute difference in the submatrix is |1 - 3| = 2. Thus, the answer is [[2]].
```

**Example 2:**
```
Input: grid = [[3,-1]], k = 1

Output: [[0,0]]

Explanation:

- Both k x k submatrix has only one distinct element.
- Thus, the answer is [[0, 0]].
```

**Example 3:**
```
Input: grid = [[1,-2,3],[2,3,5]], k = 2

Output: [[1,2]]

Explanation:

- There are two possible k × k submatrix:
    - Starting at (0, 0): [[1, -2], [2, 3]].
        - Distinct values in the submatrix are [1, -2, 2, 3].
        - The minimum absolute difference in the submatrix is |1 - 2| = 1.
    - Starting at (0, 1): [[-2, 3], [3, 5]].
        - Distinct values in the submatrix are [-2, 3, 5].
        - The minimum absolute difference in the submatrix is |3 - 5| = 2.
- Thus, the answer is [[1, 2]].
```

**Constraints:**
- 1 <= m == grid.length <= 30
- 1 <= n == grid[i].length <= 30
- -105 <= grid[i][j] <= 105
- 1 <= k <= min(m, n)

---

## Solutions

### ⭐ Solution 1: [Approach Name]
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Iterate over every possible k x k submatrix by its top-left corner.
- For each window, insert all values into a TreeSet to keep only distinct values in sorted order.
- If the set has only one value, answer for that window is 0.
- Otherwise, scan adjacent values in sorted order and take the minimum gap as the minimum absolute difference.
- Store that value in the result grid at the corresponding window position.

**Complexity:**
- ⏱️ Time: O()
- 💾 Space: O()

---

## Key Insights

- Minimum absolute difference among numbers is found between adjacent elements after sorting.
- TreeSet gives both deduplication and sorted order, so one structure solves both needs.
- If all elements are equal, distinct set size is 1, so the minimum absolute difference is 0.

---

**Date Solved:** March 20, 2026  
**Review Count:** 0  
**Next Review:** March 20, 2026
