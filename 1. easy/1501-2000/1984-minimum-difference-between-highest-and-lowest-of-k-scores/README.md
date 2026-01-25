# [1984]. Minimum Difference Between Highest and Lowest of K Scores

**Difficulty:** Easy  
**Topics:** `Array`, `Sliding Window`, `Sorting`  
**Companies:** N/A  
**Link:** [Minimum Difference Between Highest and Lowest of K Scores](https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/)

---

## Problem Statement

You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student. You are also given an integer k.

Pick the scores of any k students from the array so that the difference between the highest and the lowest of the k scores is minimized.

Return the minimum possible difference.

**Example 1:**
```
Input: nums = [90], k = 1
Output: 0
Explanation: There is one way to pick score(s) of one student:
- [90]. The difference between the highest and lowest score is 90 - 90 = 0.
The minimum possible difference is 0.
```

**Example 2:**
```
Input: nums = [9,4,1,7], k = 2
Output: 2
Explanation: There are six ways to pick score(s) of two students:
- [9,4,1,7]. The difference between the highest and lowest score is 9 - 4 = 5.
- [9,4,1,7]. The difference between the highest and lowest score is 9 - 1 = 8.
- [9,4,1,7]. The difference between the highest and lowest score is 9 - 7 = 2.
- [9,4,1,7]. The difference between the highest and lowest score is 4 - 1 = 3.
- [9,4,1,7]. The difference between the highest and lowest score is 7 - 4 = 3.
- [9,4,1,7]. The difference between the highest and lowest score is 7 - 1 = 6.
The minimum possible difference is 2.
```

**Constraints:**
- 1 <= k <= nums.length <= 1000
- 0 <= nums[i] <= 105

---

## Solutions

### ⭐ Solution 1: Sorting
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- **Key Insight**: To minimize the difference between highest and lowest in k elements, choose k consecutive elements from sorted array
- Sort the array in ascending order
- Use sliding window of size k
- Slide the window across sorted array and calculate difference for each window
  - Window boundaries: `[i, i+k-1]`
  - Difference = `nums[i+k-1] - nums[i]` (highest - lowest in window)
- Track minimum difference across all windows using `Math.min()`
- Initialize answer to `Integer.MAX_VALUE` to handle first comparison
- Loop condition: `i + k - 1 < n` ensures we don't go out of bounds
- Return the minimum difference found


**Complexity:**
- ⏱️ Time: O(n log n)
- 💾 Space: O(log n)

---

## Key Insights

- **Problem Pattern**: Sorting + Sliding Window optimization
- **Core Principle**: Consecutive elements in sorted array minimize range
- **Greedy Observation**: The optimal k elements must be consecutive in sorted order
- **Mathematical Proof**:
  - Let sorted array be [a₁, a₂, ..., aₙ] where a₁ ≤ a₂ ≤ ... ≤ aₙ
  - For any window [aᵢ, aᵢ₊₁, ..., aᵢ₊ₖ₋₁], difference = aᵢ₊ₖ₋₁ - aᵢ
  - If we skip any element (non-consecutive), we include a larger element, increasing the range
  - Therefore, minimum difference comes from consecutive elements
- **Example walkthrough for [9,4,1,7], k=2**:
  - Sort: [1, 4, 7, 9]
  - Window 0-1: [1,4] → diff = 4-1 = 3
  - Window 1-2: [4,7] → diff = 7-4 = 3
  - Window 2-3: [7,9] → diff = 9-7 = 2 ✓ (minimum)
  - Result: 2
- **Edge case k=1**: Difference is always 0 (single element)
- **Edge case k=n**: Only one window (entire array), return max-min
- Sliding window avoids checking all C(n,k) combinations (which would be exponential)
- Window size is fixed at k, making this a fixed-size sliding window problem
- The problem guarantees k ≤ n, so we always have at least one valid window
- With constraints (n ≤ 1000), O(n log n) is very efficient


---

**Date Solved:** January 25, 2026  
**Review Count:** 0  
**Next Review:** January 25, 2026
