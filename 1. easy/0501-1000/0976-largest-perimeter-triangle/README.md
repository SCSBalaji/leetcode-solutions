# [0976]. Largest Perimeter Triangle

**Difficulty:** Easy  
**Topics:** `Array`, `Math`, `Greedy`, `Sorting`  
**Companies:** N/A  
**Link:** [Largest Perimeter Triangle](https://leetcode.com/problems/largest-perimeter-triangle/)

---

## Problem Statement

Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

**Example 1:**
```
Input: nums = [2,1,2]
Output: 5
Explanation: You can form a triangle with three side lengths: 1, 2, and 2.
```

**Example 2:**
```
Input: nums = [1,2,1,10]
Output: 0
Explanation: 
You cannot use the side lengths 1, 1, and 2 to form a triangle.
You cannot use the side lengths 1, 1, and 10 to form a triangle.
You cannot use the side lengths 1, 2, and 10 to form a triangle.
As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.
```

**Constraints:**
- 3 <= nums.length <= 104
- 1 <= nums[i] <= 106

---

## Solutions

### ⭐ Solution 1: Sort
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Sort array in ascending order
- Iterate backward from largest three elements (indices n-3 down to 0)
- For each triplet (A[i], A[i+1], A[i+2]):
  - Check triangle inequality: `A[i] + A[i+1] > A[i+2]`
  - If valid, return sum (largest perimeter found)
- If no valid triplet found, return 0


**Complexity:**
- ⏱️ Time: O(n log n)
- 💾 Space: O(log n)

---

## Key Insights

- **Triangle Inequality**: For sides a ≤ b ≤ c, valid triangle requires `a + b > c`
- **Greedy Strategy**: After sorting, check largest triplets first (maximizes perimeter)
- **Why Only One Check?**: If a ≤ b ≤ c, then:
  - `a + c > b` always true (since c ≥ b)
  - `b + c > a` always true (both b,c ≥ a)
  - Only need to verify `a + b > c` (smallest two vs largest)
- **Example [2,1,2]**:
  - Sorted: [1,2,2]
  - Check (1,2,2): 1+2>2 ✓ → return 5
- **Example [1,2,1,10]**:
  - Sorted: [1,1,2,10]
  - Check (2,10,1): Reordered as (1,2,10): 1+2≯10 ✗
  - Check (1,1,2): 1+1≯2 ✗
  - No valid triangle → return 0
- **Early Exit**: First valid triplet is guaranteed maximum (sorted descending search)
- **Why Backward?**: Largest elements give largest perimeter if valid
- **Constraint Impact**: n ≤ 10⁴ makes O(n log n) very efficient


---

**Date Solved:** February 24, 2026  
**Review Count:** 0  
**Next Review:** February 24, 2026
