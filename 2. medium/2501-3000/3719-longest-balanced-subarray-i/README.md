# [3719]. Longest Balanced Subarray I

**Difficulty:** Medium  
**Topics:** `Array`, `Hash Table`, `Divide and Conquer`, `Segment Tree`, `Prefix Sum`  
**Companies:** N/A  
**Link:** [Longest Balanced Subarray I](https://leetcode.com/problems/longest-balanced-subarray-i/)

---

## Problem Statement

You are given an integer array nums.

A subarray is called balanced if the number of distinct even numbers in the subarray is equal to the number of distinct odd numbers.

Return the length of the longest balanced subarray.

**Example 1:**
```
Input: nums = [2,5,4,3]

Output: 4

Explanation:

- The longest balanced subarray is [2, 5, 4, 3].
- It has 2 distinct even numbers [2, 4] and 2 distinct odd numbers [5, 3]. Thus, the answer is 4.
```

**Example 2:**
```
Input: nums = [3,2,2,5,4]

Output: 5

Explanation:

- The longest balanced subarray is [3, 2, 2, 5, 4].
- It has 2 distinct even numbers [2, 4] and 2 distinct odd numbers [3, 5]. Thus, the answer is 5.
```

**Example 3:**
```
Input: nums = [1,2,3,2]

Output: 3

Explanation:

- The longest balanced subarray is [2, 3, 2].
- It has 1 distinct even number [2] and 1 distinct odd number [3]. Thus, the answer is 3.
```

**Constraints:**
- 1 <= nums.length <= 1500
- 1 <= nums[i] <= 105

---

## Solutions

### Solution 1: Brute Force
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Use nested loops to check all possible subarrays
- Outer loop (i): Starting position of subarray
- Inner loop (j): Extending position from i to end
- Maintain two HashMaps per subarray:
  - `odd`: Tracks distinct odd numbers (key = number, value = count)
  - `even`: Tracks distinct even numbers
- For each element at j:
  - Check parity using bitwise AND: `(nums[j] & 1) == 1` for odd
  - Add to appropriate HashMap
  - If `odd.size() == even.size()`: Update max length as `j - i + 1`
- Return maximum length found


**Complexity:**
- ⏱️ Time: O(n²)
- 💾 Space: O(n)

---

## Key Insights

- **Distinct vs Count**: Problem requires distinct numbers, not total count (HashMaps track this)
- **Parity Check**: `(nums[j] & 1) == 1` efficiently checks odd (LSB = 1) vs even (LSB = 0)
- **Balanced Condition**: `odd.size() == even.size()` checks equality of distinct counts
- **Example [2,5,4,3]**: 
  - Subarray [2,5,4,3]: odd={5,3}, even={2,4} → sizes equal (2==2) → length 4 ✓
- **Example [3,2,2,5,4]**: 
  - Subarray [3,2,2,5,4]: odd={3,5}, even={2,4} → sizes equal → length 5 ✓
  - Duplicate 2 doesn't affect distinct count
- **HashMap Keys**: Only keys matter for distinct count; values track frequency (unused here)
- **Subarray Reset**: HashMaps reset for each new starting position i
- **Constraint Impact**: n ≤ 1500 makes O(n²) acceptable (~2.25M operations)


---

**Date Solved:** February 10, 2026  
**Review Count:** 0  
**Next Review:** February 10, 2026
