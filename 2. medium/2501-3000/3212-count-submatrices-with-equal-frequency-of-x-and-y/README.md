# [3212]. Count Submatrices With Equal Frequency of X and Y

**Difficulty:** Medium  
**Topics:** `Array`, `Matrix`, `Prefix Sum`  
**Companies:** N/A  
**Link:** [Count Submatrices With Equal Frequency of X and Y](https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/)

---

## Problem Statement

Given a 2D character matrix grid, where grid[i][j] is either 'X', 'Y', or '.', return the number of submatrices that contain:

grid[0][0]
an equal frequency of 'X' and 'Y'.
at least one 'X'.

**Example 1:**
```
Input: grid = [["X","Y","."],["Y",".","."]]

Output: 3

Explanation:
```

![Example](./explanation1.png)

**Example 2:**
```
Input: grid = [["X","X"],["X","Y"]]

Output: 0

Explanation:

No submatrix has an equal frequency of 'X' and 'Y'.
```

**Example 3:**
```
Input: grid = [[".","."],[".","."]]

Output: 0

Explanation:

No submatrix has at least one 'X'.
```

**Constraints:**
- 1 <= grid.length, grid[i].length <= 1000
- grid[i][j] is either 'X', 'Y', or '.'.

---

## Solutions

### ⭐ Solution 1: 2D Prefix via Row Prefix + Column Accumulation
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Keep two column arrays:
  - `x[j]` = total count of `'X'` in submatrix from `(0,0)` to `(i,j)`
  - `y[j]` = total count of `'Y'` in submatrix from `(0,0)` to `(i,j)`
- For each row `i`, build running row-prefix counts `sumx` and `sumy` while scanning columns left to right.
- Update:
  - `x[j] += sumx`
  - `y[j] += sumy`
- Now `(x[j], y[j])` represents counts in the top-left-anchored submatrix ending at `(i,j)`.
- If `x[j] == y[j]` and `x[j] > 0`, count it.


**Complexity:**
- ⏱️ Time: O(n × m)
- 💾 Space: O(m)

---

## Key Insights

- Every valid submatrix must include `grid[0][0]`, so each is uniquely identified by its bottom-right corner `(i, j)`.
- You only need counts for top-left anchored rectangles, not all submatrices.
- Combining row prefix + column accumulation gives those rectangle counts in one pass.
- Condition `x[j] > 0` enforces “at least one `X`”.

---

**Date Solved:** March 19, 2026  
**Review Count:** 0  
**Next Review:** March 19, 2026
