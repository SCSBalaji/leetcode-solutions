# [1689]. Partitioning Into Minimum Number Of Deci-Binary Numbers

**Difficulty:** Medium  
**Topics:** `String`, `Greedy`  
**Companies:** N/A  
**Link:** [Partitioning Into Minimum Number Of Deci-Binary Numbers](https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/)

---

## Problem Statement

A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.

Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.

**Example 1:**
```
Input: n = "32"
Output: 3
Explanation: 10 + 11 + 11 = 32
```

**Example 2:**
```
Input: n = "82734"
Output: 8
```

**Example 3:**
```
Input: n = "27346209830709182346"
Output: 9
```

**Constraints:**
- 1 <= n.length <= 105
- n consists of only digits.
- n does not contain any leading zeros and represents a positive integer.

---

## Solutions

### ⭐ Solution 1: Find Maximum Digit
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Initialize `maxi = 0` to track largest digit
- Iterate through each character in string:
  - Convert character to digit: `n.charAt(i) - '0'`
  - Update maximum: `maxi = Math.max(maxi, dig)`
- Return maximum digit found


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Key Observation**: Minimum deci-binary numbers needed = maximum digit in n
- **Why Maximum?**: Each deci-binary number can contribute at most 1 to any digit position
  - To form digit d, need at least d deci-binary numbers (each adds 0 or 1)
- **Greedy Strategy**: Use maximum digit as answer (can't do better)
- **Example n="32"**:
  - Max digit = 3
  - Need 3 numbers: 10 + 11 + 11 = 32 ✓
  - Position 0 (tens): 1+1+1=3, Position 1 (ones): 0+1+1=2
- **Example n="82734"**:
  - Max digit = 8
  - Need 8 deci-binary numbers to satisfy the '8' in position 1 ✓
- **Example n="27346209830709182346"**:
  - Max digit = 9
  - Need exactly 9 numbers ✓
- **Constructive Proof**: Can always construct solution with max_digit numbers
  - For each position with digit d, use d numbers that contribute 1 at that position
- **No Need to Build**: Don't need actual deci-binary numbers, just count them
- **Early Exit Optimization**: Could return immediately when '9' found (can't be higher)


---

**Date Solved:** March 01, 2026  
**Review Count:** 0  
**Next Review:** March 01, 2026
