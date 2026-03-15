# [1614]. Maximum Nesting Depth of the Parentheses

**Difficulty:** Easy  
**Topics:** `Stack`, `String`  
**Companies:** N/A  
**Link:** [Maximum Nesting Depth of the Parentheses](https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/)

---

## Problem Statement

Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

**Example 1:**
```
Input: s = "(1+(2*3)+((8)/4))+1"

Output: 3

Explanation:

Digit 8 is inside of 3 nested parentheses in the string.
```

**Example 2:**
```
Input: s = "(1)+((2))+(((3)))"

Output: 3

Explanation:

Digit 3 is inside of 3 nested parentheses in the string.
```

**Example 3:**
```
Input: s = "()(())((()()))"

Output: 3
```

**Constraints:**
- 1 <= s.length <= 100
- s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
- It is guaranteed that parentheses expression s is a VPS.

---

## Solutions

### ⭐ Solution 1: [Approach Name]
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Use a stack to simulate currently open parentheses.
- Traverse the string character by character.
- When encountering `(`, push it onto the stack.
- When encountering `)`, pop from the stack.
- After each step, update the answer with the maximum stack size seen so far.
- Return that maximum size as the nesting depth.


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

## Key Insights

- The current stack size directly represents the current nesting depth.
- The maximum stack size reached during the scan is the final answer.
- Non-parenthesis characters do not affect depth, so they can be ignored.
- Since the string is guaranteed to be valid, every `)` will always have a matching `(` to pop.

---

**Date Solved:** March 15, 2026  
**Review Count:** 0  
**Next Review:** March 15, 2026
