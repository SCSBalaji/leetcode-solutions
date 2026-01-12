# [0066]. Plus One

**Difficulty:** Easy  
**Topics:** `Array`, `Math`  
**Companies:** N/A  
**Link:** [Plus One](https://leetcode.com/problems/plus-one/)

---

## Problem Statement

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

**Example 1:**
```
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
```

**Example 2:**
```
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
```

**Example 3:**
```
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
```

**Constraints:**
- 1 <= digits.length <= 100
- 0 <= digits[i] <= 9
- digits does not contain any leading 0's.

---

## Solutions

### ⭐ Solution 1: Schoolbook Addition with Carry
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Iterate through the array from right to left (least significant digit first)
- If current digit is 9, set it to 0 and continue (carry propagates)
- If current digit is not 9, increment it by 1 and return immediately (no carry needed)
- If loop completes (all digits were 9), create new array with length n+1
- Set first digit to 1, rest are automatically 0 (e.g., 999 → 1000)
- Optimized: No explicit carry variable needed


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

## Key Insights

- Most cases don't need full array traversal - only when digits are 9
- No need for explicit carry variable - the algorithm implicitly handles it
- Only need to allocate new array when all digits are 9 (overflow case)
- In Java, new int array is automatically initialized with zeros, so only need to set first digit to 1
- Edge case: Single digit [9] correctly becomes [1,0]
- The problem can't result in leading zeros except after overflow (which adds the leading 1)


---

**Date Solved:** January 12, 2026  
**Review Count:** 0  
**Next Review:** January 12, 2026
