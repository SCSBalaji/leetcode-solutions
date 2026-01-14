# [3701]. Compute Alternating Sum

**Difficulty:** Easy  
**Topics:** `Array`, `Simulation`  
**Companies:** N/A  
**Link:** [Compute Alternating Sum](https://leetcode.com/problems/compute-alternating-sum/)

---

## Problem Statement

You are given an integer array nums.

The alternating sum of nums is the value obtained by adding elements at even indices and subtracting elements at odd indices. That is, nums[0] - nums[1] + nums[2] - nums[3]...

Return an integer denoting the alternating sum of nums.

**Example 1:**
```
Input: nums = [1,3,5,7]

Output: -4

Explanation:

- Elements at even indices are nums[0] = 1 and nums[2] = 5 because 0 and 2 are even numbers.
- Elements at odd indices are nums[1] = 3 and nums[3] = 7 because 1 and 3 are odd numbers.
- The alternating sum is nums[0] - nums[1] + nums[2] - nums[3] = 1 - 3 + 5 - 7 = -4.
```

**Example 2:**
```
Input: nums = [100]

Output: 100

Explanation:

- The only element at even indices is nums[0] = 100 because 0 is an even number.
- There are no elements on odd indices.
- The alternating sum is nums[0] = 100.
```

**Constraints:**
- 1 <= nums.length <= 100
- 1 <= nums[i] <= 100

---

## Solutions

### ⭐ Solution 1: Iterative Index Parity
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Initialize result variable to 0
- Iterate through array with index from 0 to n-1
- Check if index is even using modulo operator (i % 2 == 0)
- If even index: add nums[i] to result
- If odd index: subtract nums[i] from result
- Return accumulated result
- Simple and straightforward implementation


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- Problem is straightforward simulation of alternating addition/subtraction
- Index parity (even/odd) determines operation: even → add, odd → subtract
- No need for auxiliary data structures - can compute in single pass
- Edge case: Single element array returns that element (only even index exists)
- Modulo operation (i % 2) efficiently checks index parity
- Result can be negative if odd-indexed elements sum > even-indexed elements sum
- Alternative approach: Could use multiplier that alternates between +1 and -1
- With constraints (n ≤ 100, nums[i] ≤ 100), no overflow concerns


---

**Date Solved:** January 14, 2026  
**Review Count:** 0  
**Next Review:** January 14, 2026
