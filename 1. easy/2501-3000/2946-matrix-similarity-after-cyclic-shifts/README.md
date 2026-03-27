# [2946]. Matrix Similarity After Cyclic Shifts

**Difficulty:** Easy  
**Topics:** `Array`, `Math`, `Matrix`, `Simulation`  
**Companies:** N/A  
**Link:** [Matrix Similarity After Cyclic Shifts](https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/)

---

## Problem Statement

You are given an m x n integer matrix mat and an integer k. The matrix rows are 0-indexed.

The following proccess happens k times:

- Even-indexed rows (0, 2, 4, ...) are cyclically shifted to the left.

![Example](./lshift.jpg)

- Odd-indexed rows (1, 3, 5, ...) are cyclically shifted to the right.

![Example](./rshift-stlone.jpg)

Return true if the final modified matrix after k steps is identical to the original matrix, and false otherwise.

**Example 1:**
```
Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 4

Output: false

Explanation:

In each step left shift is applied to rows 0 and 2 (even indices), and right shift to row 1 (odd index).
```

![Example](./t1-2.jpg)

**Example 2:**
```
Input: mat = [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2

Output: true

Explanation:
```

![Example](./t1-3.jpg)

**Example 3:**
```
Input: mat = [[2,2],[2,2]], k = 3

Output: true

Explanation:

As all the values are equal in the matrix, even after performing cyclic shifts the matrix will remain the same.
```

**Constraints:**
- 1 <= mat.length <= 25
- 1 <= mat[i].length <= 25
- 1 <= mat[i][j] <= 25
- 1 <= k <= 50

---

## Solutions

### ⭐ Solution 1: Modulo Shift Invariance Check
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Let `n` be number of columns, and reduce `k` using `k %= n` since shifting by full row length changes nothing.
- For each row and each column `j`, compare current value with the value at shifted index `(j + k) % n`.
- If any mismatch is found, return `false`.
- If all positions satisfy the condition, return `true`.

**Complexity:**
- ⏱️ Time: O(m * n)
- 💾 Space: O(1)

---

## Key Insights

- Repeating cyclic shifts depends only on `k mod n`, not raw `k`.
- For a row to remain identical after required cyclic movement, every element must match its `k`-shifted counterpart.
- Checking this directly avoids explicit simulation of `k` rounds.

---

**Date Solved:** March 27, 2026  
**Review Count:** 0  
**Next Review:** March 27, 2026
