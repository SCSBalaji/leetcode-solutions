# [3634]. Minimum Removals to Balance Array

**Difficulty:** Medium  
**Topics:** `Array`, `Sliding Window`, `Sorting`  
**Companies:** N/A  
**Link:** [Minimum Removals to Balance Array](https://leetcode.com/problems/minimum-removals-to-balance-array/)

---

## Problem Statement

You are given an integer array nums and an integer k.

An array is considered balanced if the value of its maximum element is at most k times the minimum element.

You may remove any number of elements from nums​​​​​​​ without making it empty.

Return the minimum number of elements to remove so that the remaining array is balanced.

Note: An array of size 1 is considered balanced as its maximum and minimum are equal, and the condition always holds true.

**Example 1:**
```
Input: nums = [2,1,5], k = 2

Output: 1

Explanation:

- Remove nums[2] = 5 to get nums = [2, 1].
- Now max = 2, min = 1 and max <= min * k as 2 <= 1 * 2. Thus, the answer is 1.
```

**Example 2:**
```
Input: nums = [2,1,5], k = 2

Output: 1

Explanation:

- Remove nums[2] = 5 to get nums = [2, 1].
- Now max = 2, min = 1 and max <= min * k as 2 <= 1 * 2. Thus, the answer is 1.
```

**Example 3:**
```
Input: nums = [4,6], k = 2

Output: 0

Explanation:

- Since nums is already balanced as 6 <= 4 * 2, no elements need to be removed.
```

**Constraints:**
- 1 <= nums.length <= 105
- 1 <= nums[i] <= 109
- 1 <= k <= 105

---

## Solutions

### ⭐ Solution 1: Sorting + Two Pointers
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Sort the array in ascending order
- Use sliding window with two pointers (`left`, `right`) to find longest valid subarray
- For each possible minimum element (at `left`):
  - Expand `right` while `nums[right] <= nums[left] × k` (valid condition)
  - Current window size = `right - left` (elements to keep)
  - Elements to remove = `n - windowSize`
- Track minimum removals across all windows
- Return minimum count


**Complexity:**
- ⏱️ Time: O(n log n)
- 💾 Space: O(log n)

---

## Key Insights

- **Key Observation**: After sorting, valid subarray must be contiguous (any gap breaks balance)
- **Greedy Strategy**: Find longest contiguous subarray where `max ≤ min × k`
- **Sorted Property**: In sorted array, `min = nums[left]`, `max = nums[right-1]`
- **Sliding Window**: Right pointer only moves forward (monotonic), making it O(n) not O(n²)
- **Balance Condition**: `nums[right] <= nums[left] × k` checks if current element fits window
- **Cast to Long**: `(long) nums[left] × k` prevents integer overflow (max: 10^9 × 10^5 = 10^14)
- **Example [2,1,5], k=2**:
  - Sorted: [1,2,5]
  - Window [1,2]: 2 ≤ 1×2 ✓ → keep 2, remove 1
  - Window [2,5]: 5 > 2×2 ✗ → keep 1, remove 2 (worse)
  - Minimum: 1 removal
- **Example [4,6], k=2**: Already balanced (6 ≤ 4×2) → 0 removals
- **Edge Case n=1**: Always balanced, 0 removals
- **Why Not Brute Force?**: Checking all O(2^n) subsets is exponential


---

**Date Solved:** February 06, 2026  
**Review Count:** 0  
**Next Review:** February 06, 2026
