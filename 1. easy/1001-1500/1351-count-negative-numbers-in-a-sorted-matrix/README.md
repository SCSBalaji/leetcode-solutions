# [1351]. Count Negative Numbers in a Sorted Matrix

**Difficulty:** Easy  
**Topics:** `Array`, `Binary Search`, `Matrix`  
**Companies:** N/A  
**Link:** [Count Negative Numbers in a Sorted Matrix](https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/)

---

## Problem Statement

Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

**Example 1:**
```
Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
```

**Example 2:**
```
Input: grid = [[3,2],[1,0]]
Output: 0
```

**Constraints:**
- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 100
- -100 <= grid[i][j] <= 100

---

## Solutions

### ⭐ Solution 1: Staircase Search (Top-Right to Bottom-Left)
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Start at top-right corner (row 0, column n-1)
- Use two pointers: `r` (row) and `c` (column)
- While within bounds:
  - If `grid[r][c] < 0`: All elements below in this column are negative (due to column-wise sorting)
    - Add `(rows - r)` to count (all remaining rows in this column)
    - Move left: `c--`
  - Else (non-negative): Move down: `r++`
- Return total count


**Complexity:**
- ⏱️ Time: O(m + n)
- 💾 Space: O(1)

---

## Key Insights

- **Staircase Pattern**: Start top-right, move in L-shape (left or down only)
- **Sorted Property Leverage**: 
  - Row-wise non-increasing: Elements decrease left to right
  - Column-wise non-increasing: Elements decrease top to bottom
- **Key Optimization**: When negative found, entire column below is also negative
  - Add `(rows - r)` in one step instead of counting individually
- **Why Top-Right?**: Allows binary decision at each step
  - Negative: All below are negative, go left
  - Non-negative: Current and all above are non-negative, go down
- **Example [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]]**:
  - Start (0,3): -1 → count += 4, move left
  - (0,2): 2 → move down
  - (1,2): 1 → move down
  - (2,2): -1 → count += 2, move left
  - (2,1): 1 → move down
  - (3,1): -1 → count += 1, move left
  - (3,0): -1 → count += 1, done
  - Total: 4+2+1+1 = 8 ✓
- **Alternative O(m×n)**: Brute force check every element
- **Alternative O(m log n)**: Binary search on each row for first negative
- **Why This is Optimal**: Exploits both sorting directions simultaneously


---

**Date Solved:** February 04, 2026  
**Review Count:** 0  
**Next Review:** February 04, 2026
