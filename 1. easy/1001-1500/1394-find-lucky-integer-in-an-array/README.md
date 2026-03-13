# [1394]. Find Lucky Integer in an Array

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`, `Counting`  
**Companies:** N/A  
**Link:** [Find Lucky Integer in an Array](https://leetcode.com/problems/find-lucky-integer-in-an-array/)

---

## Problem Statement

Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.

Return the largest lucky integer in the array. If there is no lucky integer return -1.

**Example 1:**
```
Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
```

**Example 2:**
```
Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
```

**Example 3:**
```
Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.
```

**Constraints:**
- 1 <= arr.length <= 500
- 1 <= arr[i] <= 500

---

## Solutions

### ⭐ Solution 1: HashMap Frequency Count
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Build a frequency map counting occurrences of each element
- Iterate through the array; if `arr[i] == map.get(arr[i])`, it's a lucky number
- Track the maximum lucky number found; return `-1` if none exists


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

## Key Insights

- **Lucky condition**: a number is lucky only when its value equals its frequency — simple equality check after counting
- **Max tracking**: iterating the original array (not map keys) with `Math.max` naturally finds the largest lucky number without extra sorting
- **Bounded input**: since `arr[i] <= 500`, an `int[501]` frequency array could replace the HashMap for O(1) space

---

**Date Solved:** March 13, 2026  
**Review Count:** 0  
**Next Review:** March 13, 2026
