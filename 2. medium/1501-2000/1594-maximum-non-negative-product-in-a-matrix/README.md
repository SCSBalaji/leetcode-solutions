# [1594]. Maximum Non Negative Product in a Matrix

**Difficulty:** Medium  
**Topics:** `Array`, `Dynamic Programming`, `Matrix`  
**Companies:** N/A  
**Link:** [Maximum Non Negative Product in a Matrix](https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/)

---

## Problem Statement

You are given a m x n matrix grid. Initially, you are located at the top-left corner (0, 0), and in each step, you can only move right or down in the matrix.

Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (m - 1, n - 1), find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells visited along the path.

Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative, return -1.

Notice that the modulo is performed after getting the maximum product.

![Example](./product1.jpg)

**Example 1:**
```
Input: grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
Output: -1
Explanation: It is not possible to get non-negative product in the path from (0, 0) to (2, 2), so return -1.
```

![Example](./product2.jpg)

**Example 2:**
```
Input: grid = [[1,-2,1],[1,-2,1],[3,-4,1]]
Output: 8
Explanation: Maximum non-negative product is shown (1 * 1 * -2 * -4 * 1 = 8).
```

![Example](./product3.jpg)

**Example 3:**
```
Input: grid = [[1,3],[0,-4]]
Output: 0
Explanation: Maximum non-negative product is shown (1 * 0 * -4 = 0).
```

**Constraints:**
- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 15
- -4 <= grid[i][j] <= 4

---

## Solutions

### ⭐ Solution 1: Dynamic Programming with Max/Min Product States
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- At each cell, track two values:
1. Maximum product to reach this cell
2. Minimum product to reach this cell
- Both are needed because multiplying by a negative can swap best and worst.
- Transition uses only top and left neighbors:
1. Multiply current cell value with neighbor max
2. Multiply current cell value with neighbor min
3. Take max of all candidates for new max, min of all candidates for new min
- Use 1D arrays `max[]` and `min[]` to store current row states and update left-to-right.
- Final answer is `max[n-1]`; if negative return `-1`, else return `max[n-1] % (1e9+7)`.


**Complexity:**
- ⏱️ Time: O(m * n)
- 💾 Space: O(n)

---

## Key Insights

- Sign flips make single-state DP insufficient; dual-state (max + min) DP is mandatory.
- Only top and left transitions exist, so row-wise rolling arrays reduce space from O(mn) to O(n).
- Modulo is applied only at the end, because intermediate comparisons must use true product values.

---

**Date Solved:** March 23, 2026  
**Review Count:** 0  
**Next Review:** March 23, 2026
