# [1365]. How Many Numbers Are Smaller Than the Current Number

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`, `Sorting`, `Counting Sort`  
**Companies:** N/A  
**Link:** [How Many Numbers Are Smaller Than the Current Number](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/)

---

## Problem Statement

Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

**Example 1:**
```
Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
```

**Example 2:**
```
Input: nums = [6,5,4,8]
Output: [2,1,0,3]
```

**Example 3:**
```
Input: nums = [7,7,7,7]
Output: [0,0,0,0]
```

**Constraints:**
- 2 <= nums.length <= 500
- 0 <= nums[i] <= 100

---

## Solutions

### ⭐ Solution 1: Brute Force
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Initialize result array of same length as input
- Outer loop (i): For each element in nums
- Inner loop (j): Compare with every other element
  - If `nums[i] > nums[j]`, increment `result[i]`
- Return result array containing counts


**Complexity:**
- ⏱️ Time: O(n²)
- 💾 Space: O(n)

---

## Key Insights

- **Brute Force Approach**: Direct comparison of every element with every other element
- **Count Strategy**: For each element, count how many are strictly smaller
- **Self-Comparison Harmless**: When i==j, condition `nums[i] > nums[j]` is false (no count)
- **Example [8,1,2,2,3]**:
  - 8: Compare with [1,2,2,3] → 4 smaller ✓
  - 1: Compare with [8,2,2,3] → 0 smaller ✓
  - 2: Compare with [8,1,2,3] → 1 smaller (only 1) ✓
  - 3: Compare with [8,1,2,2] → 3 smaller ✓
- **Duplicates Handled**: Each duplicate counts independently (2 appears twice, both get count 1)
- **All Equal Case**: [7,7,7,7] → all counts are 0 (no element strictly smaller)
- **Constraint Leverage**: n ≤ 500 makes O(n²) viable (~250K operations)
- **Optimization Available**: Sorting + binary search O(n log n), or counting sort O(n+k) where k=100


---

**Date Solved:** February 13, 2026  
**Review Count:** 0  
**Next Review:** February 13, 2026
