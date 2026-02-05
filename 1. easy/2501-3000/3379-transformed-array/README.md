# [3379]. Transformed Array

**Difficulty:** Easy  
**Topics:** `Array`, `Simulation`  
**Companies:** N/A  
**Link:** [Transformed Array](https://leetcode.com/problems/transformed-array/)

---

## Problem Statement

You are given an integer array nums that represents a circular array. Your task is to create a new array result of the same size, following these rules:

For each index i (where 0 <= i < nums.length), perform the following independent actions:
- If nums[i] > 0: Start at index i and move nums[i] steps to the right in the circular array. Set result[i] to the value of the index where you land.
- If nums[i] < 0: Start at index i and move abs(nums[i]) steps to the left in the circular array. Set result[i] to the value of the index where you land.
- If nums[i] == 0: Set result[i] to nums[i].
Return the new array result.

Note: Since nums is circular, moving past the last element wraps around to the beginning, and moving before the first element wraps back to the end.

**Example 1:**
```
Input: nums = [3,-2,1,1]

Output: [1,1,1,3]

Explanation:

- For nums[0] that is equal to 3, If we move 3 steps to right, we reach nums[3]. So result[0] should be 1.
- For nums[1] that is equal to -2, If we move 2 steps to left, we reach nums[3]. So result[1] should be 1.
- For nums[2] that is equal to 1, If we move 1 step to right, we reach nums[3]. So result[2] should be 1.
- For nums[3] that is equal to 1, If we move 1 step to right, we reach nums[0]. So result[3] should be 3.
```

**Example 2:**
```
Input: nums = [-1,4,-1]

Output: [-1,-1,4]

Explanation:

- For nums[0] that is equal to -1, If we move 1 step to left, we reach nums[2]. So result[0] should be -1.
- For nums[1] that is equal to 4, If we move 4 steps to right, we reach nums[2]. So result[1] should be -1.
- For nums[2] that is equal to -1, If we move 1 step to left, we reach nums[1]. So result[2] should be 4.
```

**Constraints:**
- 1 <= nums.length <= 100
- -100 <= nums[i] <= 100

---

## Solutions

### ⭐ Solution 1: Traversal
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Create result array of size n
- For each index i:
  - Calculate target index: `(i + nums[i]) % n`
  - Handle negative indices with double modulo: `(((i + nums[i]) % n) + n) % n`
  - Set `res[i] = nums[targetIndex]`
- Return result array


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

## Key Insights

- **Circular Array Formula**: `(((i + offset) % n) + n) % n` handles both positive and negative wrapping
- **Double Modulo Trick**: 
  - First `% n`: Reduces large offsets to range [-n+1, n-1]
  - `+ n`: Shifts negative values to positive range
  - Second `% n`: Wraps values ≥ n back to [0, n-1]
- **Why Double Modulo?**: Single modulo fails for negative numbers (e.g., -1 % 3 = -1, not 2)
- **Example [3,-2,1,1]** (n=4):
  - i=0: (0+3)%4 = 3 → res[0] = nums[3] = 1
  - i=1: ((1-2)%4 + 4)%4 = (-1+4)%4 = 3 → res[1] = nums[3] = 1
  - i=2: (2+1)%4 = 3 → res[2] = nums[3] = 1
  - i=3: (3+1)%4 = 0 → res[3] = nums[0] = 3
- **Zero Handling**: When nums[i]=0, formula gives (i+0)%n = i → res[i] = nums[i] (automatic)
- **No Conditional Logic**: Formula handles all three cases (positive/negative/zero) uniformly
- **Alternative Approach**: Use if-else for direction, but modulo is cleaner


---

**Date Solved:** February 05, 2026  
**Review Count:** 0  
**Next Review:** February 05, 2026
