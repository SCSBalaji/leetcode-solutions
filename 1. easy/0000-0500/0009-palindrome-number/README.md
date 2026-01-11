# [0009]. Palindrome Number

**Difficulty:** Easy  
**Topics:** `Math`  
**Companies:** N/A  
**Link:** [Palindrome Number](https://leetcode.com/problems/palindrome-number/)

---

## Problem Statement

Given an integer x, return true if x is a palindrome, and false otherwise.

**Example 1:**
```
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
```

**Example 2:**
```
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
```

**Example 3:**
```
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
```

**Constraints:**
- -231 <= x <= 231 - 1

---

## Solutions

### Solution 1: Brute Force
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Reverse the entire number by extracting digits one by one
- Compare the reversed number with the original
- Return false immediately if the number is negative

**Complexity:**
- ⏱️ Time: O(log10(n))
- 💾 Space: O(1)

---

### ⭐ Solution 2: Revert Half Of The Number
**File:** `Solution2.java`  
**Status:** ✅ Accepted

**Approach:**
- Optimize by only reversing half of the number
- Return false early for negative numbers and numbers ending in 0 (except 0 itself)
- Compare the first half with the reversed second half
- Handle odd-length numbers by dividing the reversed half by 10


**Complexity:**
- ⏱️ Time: O(log10(n))
- 💾 Space: O(1)

---

## Key Insights

- Negative numbers are never palindromes
- Numbers ending in 0 can't be palindromes (except 0 itself) because leading zeros don't exist
- Solution 2 is more optimal as it only processes half the digits
- No need to handle integer overflow since we're only reversing half the number in Solution 2

---

**Date Solved:** January 11, 2026  
**Review Count:** 0  
**Next Review:** January 11, 2026
