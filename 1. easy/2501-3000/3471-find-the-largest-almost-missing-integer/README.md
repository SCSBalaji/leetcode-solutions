# [3471]. Find the Largest Almost Missing Integer

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`  
**Companies:** N/A  
**Link:** [Find the Largest Almost Missing Integer](https://leetcode.com/problems/find-the-largest-almost-missing-integer/)

---

## Problem Statement

You are given an integer array nums and an integer k.

An integer x is almost missing from nums if x appears in exactly one subarray of size k within nums.

Return the largest almost missing integer from nums. If no such integer exists, return -1.

A subarray is a contiguous sequence of elements within an array.

**Example 1:**
```
Input: nums = [3,9,2,1,7], k = 3

Output: 7

Explanation:

- 1 appears in 2 subarrays of size 3: [9, 2, 1] and [2, 1, 7].
- 2 appears in 3 subarrays of size 3: [3, 9, 2], [9, 2, 1], [2, 1, 7].
- 3 appears in 1 subarray of size 3: [3, 9, 2].
- 7 appears in 1 subarray of size 3: [2, 1, 7].
- 9 appears in 2 subarrays of size 3: [3, 9, 2], and [9, 2, 1].
We return 7 since it is the largest integer that appears in exactly one subarray of size k.
```

**Example 2:**
```
Input: nums = [3,9,7,2,1,7], k = 4

Output: 3

Explanation:

- 1 appears in 2 subarrays of size 4: [9, 7, 2, 1], [7, 2, 1, 7].
- 2 appears in 3 subarrays of size 4: [3, 9, 7, 2], [9, 7, 2, 1], [7, 2, 1, 7].
- 3 appears in 1 subarray of size 4: [3, 9, 7, 2].
- 7 appears in 3 subarrays of size 4: [3, 9, 7, 2], [9, 7, 2, 1], [7, 2, 1, 7].
- 9 appears in 2 subarrays of size 4: [3, 9, 7, 2], [9, 7, 2, 1].
We return 3 since it is the largest and only integer that appears in exactly one subarray of size k.
```

**Example 3:**
```
Input: nums = [0,0], k = 1

Output: -1

Explanation:

There is no integer that appears in only one subarray of size 1.
```

**Constraints:**
- 1 <= nums.length <= 50
- 0 <= nums[i] <= 50
- 1 <= k <= nums.length

---

## Solutions

### ⭐ Solution 1: Sliding Window with HashMap + HashSet
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Use HashMap to count how many subarrays contain each distinct number
- Outer loop: Iterate through all valid subarray starting positions [0, n-k]
- For each subarray [i, i+k):
  - Use HashSet to track distinct numbers in current window (avoid duplicates)
  - Add each unique number from HashSet to HashMap frequency count
- After scanning all subarrays:
  - Find all numbers with count == 1 (appears in exactly one subarray)
  - Return maximum among them, or -1 if none found


**Complexity:**
- ⏱️ Time: O(n × k)
- 💾 Space: O(n)

---

## Key Insights

- **Almost Missing Definition**: Number appears in exactly one subarray of size k
- **Distinct Counting**: HashSet ensures duplicates within same subarray counted only once
- **Why HashSet?**: [3,3,3] window should count '3' only once for that subarray
- **Example [3,9,2,1,7], k=3**:
  - Subarrays: [3,9,2], [9,2,1], [2,1,7]
  - Count: {3→1, 9→2, 2→3, 1→2, 7→1}
  - Almost missing: 3 and 7 (count=1)
  - Return max: 7 ✓
- **Example [3,9,7,2,1,7], k=4**:
  - Subarrays: [3,9,7,2], [9,7,2,1], [7,2,1,7]
  - Count: {3→1, 9→2, 7→3, 2→3, 1→2}
  - Only 3 has count=1 → return 3 ✓
- **Example [0,0], k=1**:
  - Subarrays: [0], [0]
  - Count: {0→2}
  - No count=1 → return -1 ✓
- **Two-Phase Strategy**: First count all occurrences, then find max with count=1
- **Edge Case**: All numbers appear multiple times → return -1
- **Constraint Leverage**: Small n,k (≤50) makes O(n×k) very efficient


---

**Date Solved:** February 23, 2026  
**Review Count:** 0  
**Next Review:** February 23, 2026
