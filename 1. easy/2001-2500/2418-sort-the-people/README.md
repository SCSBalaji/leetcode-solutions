# [2418]. Sort the People

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`, `String`, `Sorting`  
**Companies:** N/A  
**Link:** [Sort the People](https://leetcode.com/problems/sort-the-people/)

---

## Problem Statement

You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.

For each index i, names[i] and heights[i] denote the name and height of the ith person.

Return names sorted in descending order by the people's heights.

**Example 1:**
```
Input: names = ["Mary","John","Emma"], heights = [180,165,170]
Output: ["Mary","Emma","John"]
Explanation: Mary is the tallest, followed by Emma and John.
```

**Example 2:**
```
Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
Output: ["Bob","Alice","Bob"]
Explanation: The first Bob is the tallest, followed by Alice and the second Bob.
```


**Constraints:**
- n == names.length == heights.length
- 1 <= n <= 103
- 1 <= names[i].length <= 20
- 1 <= heights[i] <= 105
- names[i] consists of lower and upper case English letters.
- All the values of heights are distinct.

---

## Solutions

### ⭐ Solution 1: HashMap + Sorting
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Build a map from `height -> name` using one pass over both arrays.
- Sort the `heights` array in ascending order.
- Traverse sorted heights from right to left (tallest to shortest).
- For each height, fetch the corresponding name from the map and place it into result array from left to right.
- Return the result array.


**Complexity:**
- ⏱️ Time: O(n log n)
- 💾 Space: O(n)

---

## Key Insights

- Heights are distinct, so `height -> name` mapping is safe (no collisions/overwrites).
- Sorting heights gives rank order; reverse traversal gives descending-by-height directly.
- This avoids sorting pairs/objects explicitly.
- Time complexity is dominated by sorting: $O(n \log n)$.
- Extra space is $O(n)$ for the map and output array.

---

**Date Solved:** March 16, 2026  
**Review Count:** 0  
**Next Review:** March 16, 2026
