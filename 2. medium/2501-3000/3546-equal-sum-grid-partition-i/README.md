# [3546]. Equal Sum Grid Partition I

**Difficulty:** Medium  
**Topics:** `Array`, `Matrix`, `Enumeration`, `Prefix Sum`  
**Companies:** N/A  
**Link:** [Equal Sum Grid Partition I](https://leetcode.com/problems/equal-sum-grid-partition-i/)

---

## Problem Statement

You are given an m x n matrix grid of positive integers. Your task is to determine if it is possible to make either one horizontal or one vertical cut on the grid such that:

- Each of the two resulting sections formed by the cut is non-empty.
- The sum of the elements in both sections is equal.
Return true if such a partition exists; otherwise return false.

![Example](./example.jpeg)

**Example 1:**
```
Input: grid = [[1,4],[2,3]]

Output: true

Explanation:

A horizontal cut between row 0 and row 1 results in two non-empty sections, each with a sum of 5. Thus, the answer is true.
```

**Example 2:**
```
Input: grid = [[1,3],[2,4]]

Output: false

Explanation:

No horizontal or vertical cut results in two non-empty sections with equal sums. Thus, the answer is false.
```

**Constraints:**
- 1 <= m == grid.length <= 105
- 1 <= n == grid[i].length <= 105
- 2 <= m * n <= 105
- 1 <= grid[i][j] <= 105

---

## Solutions

### ⭐ Solution 1: Total Sum + Running Row/Column Prefix Cut Check
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Compute total sum of all cells.
- If total is odd, return false immediately (cannot split equally).
- Let target = total / 2.
- Check horizontal cuts:
1. Accumulate row sums from top to bottom (stop at m-2 so both parts are non-empty).
2. If running sum equals target, valid partition exists.
- Check vertical cuts similarly:
1. Accumulate column sums from left to right (stop at n-2).
2. If running sum equals target, valid partition exists.
- If no cut matches target, return false.

**Complexity:**
- ⏱️ Time: O(m * n)
- 💾 Space: O(1)

---

## Key Insights

- A valid cut exists iff one side’s sum is exactly half of total.
- Because all grid values are positive, running sums are monotonic, so one pass over possible horizontal and vertical cuts is sufficient.
- Restricting cuts to m-1 and n-1 boundaries guarantees both resulting sections are non-empty.

---

**Date Solved:** March 25, 2026  
**Review Count:** 0  
**Next Review:** March 25, 2026
