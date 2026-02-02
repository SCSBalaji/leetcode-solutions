# [3467]. Transform Array by Parity

**Difficulty:** Easy  
**Topics:** `Array`, `Sorting`, `Counting`  
**Companies:** N/A  
**Link:** [Transform Array by Parity](https://leetcode.com/problems/transform-array-by-parity/)

---

## Problem Statement

You are given an integer array nums. Transform nums by performing the following operations in the exact order specified:

1. Replace each even number with 0.
2. Replace each odd numbers with 1.
3. Sort the modified array in non-decreasing order.
Return the resulting array after performing these operations.

**Example 1:**
```
Input: nums = [4,3,2,1]

Output: [0,0,1,1]

Explanation:

- Replace the even numbers (4 and 2) with 0 and the odd numbers (3 and 1) with 1. Now, nums = [0, 1, 0, 1].
- After sorting nums in non-descending order, nums = [0, 0, 1, 1].
```

**Example 2:**
```
Input: nums = [1,5,1,4,2]

Output: [0,0,1,1,1]

Explanation:

- Replace the even numbers (4 and 2) with 0 and the odd numbers (1, 5 and 1) with 1. Now, nums = [1, 1, 1, 0, 0].
- After sorting nums in non-descending order, nums = [0, 0, 1, 1, 1].
```


**Constraints:**
- 1 <= nums.length <= 100
- 1 <= nums[i] <= 1000

---

## Solutions

### ⭐ Solution 1: Modulo + Sort
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Iterate through array and replace each element with `nums[i] % 2`
  - Even numbers: `nums[i] % 2 = 0`
  - Odd numbers: `nums[i] % 2 = 1`
- Sort the modified array using `Arrays.sort()`
- Return the sorted array (all 0s before all 1s)


**Complexity:**
- ⏱️ Time: O(n log n)
- 💾 Space: O(n)

---

## Key Insights

- **Modulo Magic**: `num % 2` converts any number to its parity (0=even, 1=odd)
- **Automatic Ordering**: After sorting, binary array naturally has all 0s before 1s
- **In-place Transformation**: Modifies original array, no extra space needed
- **Example [4,3,2,1]**: After modulo [0,1,0,1] → After sort [0,0,1,1]
- **Example [1,5,1,4,2]**: After modulo [1,1,1,0,0] → After sort [0,0,1,1,1]
- **Why Not Count?**: Could count evens/odds and fill array, but sort is simpler with small n
- **Alternative O(n)**: Count zeros, fill first k positions with 0, rest with 1 (faster but less clean)
- **Constraint Leverage**: n ≤ 100 makes O(n log n) perfectly acceptable


---

**Date Solved:** February 02, 2026  
**Review Count:** 0  
**Next Review:** February 02, 2026
