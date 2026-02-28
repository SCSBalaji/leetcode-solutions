# [0674]. Longest Continuous Increasing Subsequence

**Difficulty:** Easy  
**Topics:** `Array`  
**Companies:** N/A  
**Link:** [Longest Continuous Increasing Subsequence](https://leetcode.com/problems/longest-continuous-increasing-subsequence/)

---

## Problem Statement

Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.

A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].

**Example 1:**
```
Input: nums = [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
4.
```

**Example 2:**
```
Input: nums = [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2] with length 1. Note that it must be strictly
increasing.
```

**Constraints:**
- 1 <= nums.length <= 104
- -109 <= nums[i] <= 109

---

## Solutions

### ⭐ Solution 1: Sliding Window
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Track `anchor` (start of current increasing sequence) and `ans` (max length found)
- Iterate through array with index i:
  - If current element ≤ previous element (`nums[i-1] >= nums[i]`):
    - Reset anchor to i (start new sequence)
  - Calculate current window length: `i - anchor + 1`
  - Update max length: `ans = Math.max(ans, currentLength)`
- Return maximum length found


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Anchor Reset Pattern**: When sequence breaks (non-increasing), start fresh from current position
- **Window Length Formula**: `i - anchor + 1` gives current sequence length (inclusive)
- **Continuous Requirement**: Break resets anchor (unlike LIS which allows gaps)
- **Example [1,3,5,4,7]**:
  - i=0: anchor=0, length=1, ans=1
  - i=1: 1<3✓, anchor=0, length=2, ans=2
  - i=2: 3<5✓, anchor=0, length=3, ans=3
  - i=3: 5≥4✗, anchor=3, length=1, ans=3
  - i=4: 4<7✓, anchor=3, length=2, ans=3
  - Result: 3 ✓
- **Example [2,2,2,2,2]**:
  - All elements equal → anchor resets at each i
  - Max length always 1 ✓
- **Strictly Increasing**: Condition `nums[i-1] >= nums[i]` handles both decreasing and equal cases
- **No Separate Tracking**: Unlike two-pointer, single anchor suffices (don't need to track end)
- **Edge Case [5]**: Single element → length 1 (anchor=0, i=0, ans=1)


---

**Date Solved:** February 28, 2026  
**Review Count:** 0  
**Next Review:** February 28, 2026
