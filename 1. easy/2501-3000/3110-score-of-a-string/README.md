# [3110]. Score of a String

**Difficulty:** Easy  
**Topics:** `String`  
**Companies:** N/A  
**Link:** [Score of a String](https://leetcode.com/problems/score-of-a-string/)

---

## Problem Statement

You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.

Return the score of s.

**Example 1:**
```
Input: s = "hello"

Output: 13

Explanation:

The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111. So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.
```

**Example 2:**
```
Input: s = "zaz"

Output: 50

Explanation:

The ASCII values of the characters in s are: 'z' = 122, 'a' = 97. So, the score of s would be |122 - 97| + |97 - 122| = 25 + 25 = 50.
```

**Constraints:**
- 2 <= s.length <= 100
- s consists only of lowercase English letters.

---

## Solutions

### ⭐ Solution 1: Linear Iteration
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Initialize score variable to 0
- Iterate through string from index 0 to length-2 (to avoid out of bounds)
- For each position i, calculate absolute difference between current and next character
- Use `s.charAt(i)` to get ASCII value of characters
- Subtract ASCII values: `s.charAt(i) - s.charAt(i + 1)`
- Use `Math.abs()` to get absolute difference
- Add each difference to running score
- Return accumulated score


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- Problem requires comparing adjacent characters only (not all pairs)
- `charAt()` automatically returns ASCII value as int when used in arithmetic
- Loop runs n-1 times for string of length n (comparing adjacent pairs)
- Absolute value ensures difference is always positive regardless of order
- No need to explicitly convert characters to ASCII - implicit in subtraction
- Minimum possible score is 0 (all characters identical, e.g., "aaa")
- Maximum possible score with constraints: 25 × 99 = 2475 (alternating 'a' and 'z')
- String guaranteed to have at least 2 characters, so no edge case handling needed
- Works efficiently due to small constraint (n ≤ 100)


---

**Date Solved:** January 15, 2026  
**Review Count:** 0  
**Next Review:** January 15, 2026
