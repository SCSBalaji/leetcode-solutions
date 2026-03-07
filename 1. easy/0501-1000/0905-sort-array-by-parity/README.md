# [0905]. Sort Array By Parity

**Difficulty:** Easy  
**Topics:** `Array`, `Two Pointers`, `Sorting`  
**Companies:** N/A  
**Link:** [Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/)

---

## Problem Statement

Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

**Example 1:**
```
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
```

**Example 2:**
```
Input: nums = [0]
Output: [0]
```

**Constraints:**
- 1 <= nums.length <= 5000
- 0 <= nums[i] <= 5000

---

## Solutions

### ⭐ Solution 1: Two Pointers (In-Place Swap)
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Use two pointers: `l` (left, starts at 0) and `r` (right, starts at n-1)
- While `l < r`:
  - If `nums[l]` is even: already in correct position, advance `l++`
  - If `nums[r]` is odd: already in correct position, retreat `r--`
  - Else: `nums[l]` is odd and `nums[r]` is even → swap them, then `l++`, `r--`
- Return modified array in-place


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Three-Case Logic**: Even-left (skip), Odd-right (skip), Mismatch (swap)
- **In-Place**: Modifies original array directly (no auxiliary space)
- **Any Valid Order Accepted**: Problem allows any arrangement of evens before odds
- **Example [3,1,2,4]**:
  - l=0(3 odd), r=3(4 even) → swap → [4,1,2,3], l=1, r=2
  - l=1(1 odd), r=2(2 even) → swap → [4,2,1,3], l=2, r=1
  - l≥r → done ✓
- **Example [0]**: Single element, loop never enters → return [0] ✓
- **Why Skip Both Pointers After Swap?**: After swap, `nums[l]` is confirmed even, `nums[r]` is confirmed odd
- **Dutch Flag Variant**: Similar to Dutch National Flag partition problem (3-way partition)
- **Alternative**: Extra array collecting evens then odds (O(n) space, simpler code)


---

**Date Solved:** March 07, 2026  
**Review Count:** 0  
**Next Review:** March 07, 2026
