# [1480]. Running Sum of 1d Array

**Difficulty:** Easy  
**Topics:** `Array`, `Prefix Sum`  
**Companies:** N/A  
**Link:** [Running Sum of 1d Array](https://leetcode.com/problems/running-sum-of-1d-array/)

---

## Problem Statement

Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

**Example 1:**
```
Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
```

**Example 2:**
```
Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
```

**Example 3:**
```
Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]
```

**Constraints:**
- 1 <= nums.length <= 1000
- -10^6 <= nums[i] <= 10^6

---

## Solutions

### ⭐ Solution 1: Prefix Sum
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Create result array `runningSum[]` of same length as input
- Initialize first element: `runningSum[0] = nums[0]`
- Iterate from index 1 to n-1:
  - Calculate: `runningSum[i] = runningSum[i-1] + nums[i]`
  - Each position holds sum of all previous elements plus current
- Return result array


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

## Key Insights

- **Prefix Sum Pattern**: Each position stores cumulative sum up to that index
- **Recurrence Relation**: `sum[i] = sum[i-1] + nums[i]` (dynamic programming approach)
- **Example [1,2,3,4]**:
  - runningSum[0] = 1
  - runningSum[1] = 1 + 2 = 3
  - runningSum[2] = 3 + 3 = 6
  - runningSum[3] = 6 + 4 = 10
  - Result: [1,3,6,10] ✓
- **Example [3,1,2,10,1]**: [3, 4, 6, 16, 17] ✓
- **In-Place Alternative**: Could modify nums[] directly to save space (O(1) extra space)
- **Dependency**: Each element depends only on previous sum (no need to recalculate from start)
- **Applications**: Used in range sum queries, subarray problems, difference arrays


---

**Date Solved:** February 26, 2026  
**Review Count:** 0  
**Next Review:** February 26, 2026
