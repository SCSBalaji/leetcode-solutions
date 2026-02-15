# [1636]. Sort Array by Increasing Frequency

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`, `Sorting`  
**Companies:** N/A  
**Link:** [Sort Array by Increasing Frequency](https://leetcode.com/problems/sort-array-by-increasing-frequency/)

---

## Problem Statement

Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

**Example 1:**
```
Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
```

**Example 2:**
```
Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
```

**Example 3:**
```
Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
```

**Constraints:**
- 1 <= nums.length <= 100
- -100 <= nums[i] <= 100

---

## Solutions

### ⭐ Solution 1: Customized Sorting
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- - Build frequency map using HashMap: `freq[num] = count`
- Convert primitive int[] to Integer[] (needed for custom comparator)
- Sort with custom comparator:
  - Primary: Sort by frequency (ascending)
  - Secondary: If frequencies equal, sort by value (descending)
- Convert Integer[] back to int[] for return


**Complexity:**
- ⏱️ Time: O(n log n)
- 💾 Space: O(n)

---

## Key Insights

- **Two-Level Sorting**: Frequency first, then value (with different orders)
- **Custom Comparator Logic**:
  - `freq.get(a).equals(freq.get(b))`: Check if frequencies match
  - `Integer.compare(b, a)`: Reverse order for values (b before a = descending)
  - `Integer.compare(freq.get(a), freq.get(b))`: Normal order for frequency (ascending)
- **Boxing Requirement**: Arrays.sort() with comparator requires Integer[], not int[]
- **Example [1,1,2,2,2,3]**:
  - Frequencies: {1→2, 2→3, 3→1}
  - Sort: 3(freq=1), 1(freq=2), 2(freq=3) → [3,1,1,2,2,2] ✓
- **Example [2,3,1,3,2]**:
  - Frequencies: {1→1, 2→2, 3→2}
  - Same freq for 2 & 3 → sort by value desc: 3 before 2
  - Result: [1,3,3,2,2] ✓
- **getOrDefault**: Handles first occurrence (returns 0 if key not present)
- **equals() vs ==**: Use equals() for Integer comparison (object reference issue)
- **Constraint Leverage**: Small n (≤100) makes O(n log n) very efficient


---

**Date Solved:** February 15, 2026  
**Review Count:** 0  
**Next Review:** February 15, 2026
