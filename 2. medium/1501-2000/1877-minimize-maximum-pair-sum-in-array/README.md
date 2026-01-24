# [1877]. Minimize Maximum Pair Sum in Array

**Difficulty:** Medium  
**Topics:** `Array`, `Two Pointers`, `Greedy`, `Sorting`  
**Companies:** N/A  
**Link:** [Minimize Maximum Pair Sum in Array](https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/)

---

## Problem Statement

The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.

- For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:

- Each element of nums is in exactly one pair, and
- The maximum pair sum is minimized.
Return the minimized maximum pair sum after optimally pairing up the elements.

**Example 1:**
```
Input: nums = [3,5,2,3]
Output: 7
Explanation: The elements can be paired up into pairs (3,3) and (5,2).
The maximum pair sum is max(3+3, 5+2) = max(6, 7) = 7.
```

**Example 2:**
```
Input: nums = [3,5,4,2,4,6]
Output: 8
Explanation: The elements can be paired up into pairs (3,5), (4,4), and (6,2).
The maximum pair sum is max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8.
```

**Constraints:**
- n == nums.length
- 2 <= n <= 105
- n is even.
- 1 <= nums[i] <= 105

---

## Solutions

### ⭐ Solution 1: Sorting
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- **Key Insight**: To minimize the maximum pair sum, pair smallest elements with largest elements
- Sort the array in ascending order
- Use two-pointer technique:
  - Left pointer starts at beginning (smallest elements)
  - Right pointer starts at end (largest elements)
- Pair first element with last, second with second-last, etc.
- Track the maximum sum among all pairs
- **Greedy Strategy**: Pairing extremes balances out the sums
  - If we pair two large numbers, their sum would be very high
  - If we pair two small numbers with remaining large numbers, one pair will still be very high
  - Pairing small with large distributes values optimally
- Iterate through first half of sorted array
- For each index i, pair `nums[i]` with `nums[n-1-i]`
- Keep track of maximum sum using `Math.max()`
- Return the maximum pair sum found


**Complexity:**
- ⏱️ Time: O(n log n)
- 💾 Space: O(log n)

---

## Key Insights

- **Problem Type**: Greedy algorithm with sorting optimization
- **Core Principle**: Minimize maximum by balancing extremes (pairing min with max)
- **Why sorting works**: After sorting, pairing opposite ends guarantees balanced sums
- **Mathematical Proof**:
  - Let sorted array be [a₁, a₂, ..., aₙ] where a₁ ≤ a₂ ≤ ... ≤ aₙ
  - Optimal pairing: (a₁, aₙ), (a₂, aₙ₋₁), ..., (aₙ/₂, aₙ/₂₊₁)
  - Any other pairing would create at least one pair with sum ≥ current maximum
  - Example: If we pair (a₁, a₂), we must pair larger numbers together, increasing max sum
- **Example walkthrough for [3,5,4,2,4,6]**:
  - Sort: [2, 3, 4, 4, 5, 6]
  - Pairs: (2,6)=8, (3,5)=8, (4,4)=8
  - Maximum: 8 (all pairs equal in this case)
  - Alternative pairing (2,3)=5, (4,4)=8, (5,6)=11 → max=11 (worse!)
- **Intuition**: Pairing smallest with largest "wastes" large value on small value, keeping sums moderate
- **Edge case**: When array has duplicates, pairing strategy still works optimally
- Two-pointer pattern after sorting is common in pairing/partitioning problems
- The middle pairs will always have sums between the extreme pairs
- With constraints (n ≤ 10⁵), O(n log n) sorting is efficient
- Alternative approaches (like trying all permutations) would be O(n!) - infeasible


---

**Date Solved:** January 24, 2026  
**Review Count:** 0  
**Next Review:** January 24, 2026
