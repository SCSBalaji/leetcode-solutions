# [1920]. Build Array from Permutation

**Difficulty:** Easy  
**Topics:** `Array`, `Simulation`  
**Companies:** N/A  
**Link:** [Build Array from Permutation](https://leetcode.com/problems/build-array-from-permutation/)

---

## Problem Statement

Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.

A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).

**Example 1:**
```
Input: nums = [0,2,1,5,3,4]
Output: [0,1,2,4,5,3]
Explanation: The array ans is built as follows: 
ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
    = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
    = [0,1,2,4,5,3]
```

**Example 2:**
```
Input: nums = [5,0,1,2,3,4]
Output: [4,5,0,1,2,3]
Explanation: The array ans is built as follows:
ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
    = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
    = [4,5,0,1,2,3]
```

**Constraints:**
- 1 <= nums.length <= 1000
- 0 <= nums[i] < nums.length
- The elements in nums are distinct.

---

## Solutions

### ⭐ Solution 1: Build As Required
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Create a new result array `ans` of the same length as input
- Iterate through each index i from 0 to n-1
- For each position i, set `ans[i] = nums[nums[i]]`
  - First `nums[i]` gets the value at index i
  - Second `nums[...]` uses that value as an index to get final value
- Return the new array
- Simple and intuitive two-level indexing approach


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

### ⭐ Solution 2: Build In Place
**File:** `Solution2.java`  
**Status:** ✅ Accepted

**Approach:**
- Modify input array in-place to avoid using extra space
- **Key Trick**: Store both old and new values in same position using encoding
- Encoding formula: `nums[i] = old_value + 1000 * new_value`
  - Since nums[i] < 1000 (constraint), we can use 1000 as multiplier
  - Lower 3 digits store original value: `nums[i] % 1000`
  - Upper digits store new value: `nums[i] / 1000`
- **First pass**: Encode both values at each position
  - `nums[i] += 1000 * (nums[nums[i]] % 1000)`
  - Use `% 1000` to extract original value even if already encoded
- **Second pass**: Extract new values by dividing by 1000
  - `nums[i] /= 1000`
- Return modified array
- Advanced technique demonstrating bit packing concept


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Problem Essence**: Double indexing - use array values as indices
- **Solution 1**: Straightforward approach, easy to understand and debug
- **Solution 2**: Space-optimized using clever encoding technique
- The encoding trick works because:
  - All values are < 1000 (constraint guarantees this)
  - We can "pack" two numbers into one using multiplication by 1000
  - Original value preserved in lower digits, new value in upper digits
- Solution 2 demonstrates important interview concept: in-place array manipulation
- Both solutions have O(n) time, but Solution 2 achieves O(1) space
- Trade-off: Solution 1 is more readable, Solution 2 is more space-efficient
- The permutation property ensures all indices are valid (no out-of-bounds)
- Example encoding: If old=5, new=3 → encoded = 5 + 1000*3 = 3005
  - Extract old: 3005 % 1000 = 5
  - Extract new: 3005 / 1000 = 3
- Alternative encoding methods: bitwise operations, using sign bit (but harder to read)
- For interviews: Start with Solution 1, then optimize to Solution 2 if asked for O(1) space


---

**Date Solved:** January 20, 2026  
**Review Count:** 0  
**Next Review:** January 20, 2026
