# [1249]. Minimum Remove to Make Valid Parentheses

**Difficulty:** Medium  
**Topics:** `String`, `Stack`  
**Companies:** N/A  
**Link:** [Minimum Remove to Make Valid Parentheses](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/)

---

## Problem Statement

Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

- It is the empty string, contains only lowercase characters, or
- It can be written as AB (A concatenated with B), where A and B are valid strings, or
- It can be written as (A), where A is a valid string.

**Example 1:**
```
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
```

**Example 2:**
```
Input: s = "a)b(c)d"
Output: "ab(c)d"
```

**Example 3:**
```
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
```

**Constraints:**
- 1 <= s.length <= 105
- s[i] is either '(' , ')', or lowercase English letter.

---

## Solutions

### ⭐ Solution 1: Stack + Index Set
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Use Stack to track indices of unmatched '(' parentheses
- Use HashSet to store indices of characters to remove
- **First pass**: Scan through string
  - If '(': Push index to stack
  - If ')': If stack empty (no matching '('), add index to removal set; else pop from stack (matched pair)
  - Ignore lowercase letters
- **After scan**: Remaining indices in stack are unmatched '(' → add all to removal set
- **Second pass**: Build result StringBuilder, skip indices in removal set
- Return final string


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

## Key Insights

- **Stack Pattern**: Tracks opening parentheses waiting for closure
- **Two-pass Strategy**: First identifies invalid indices, second builds result
- **Invalid Cases**:
  - ')' with no matching '(' → Remove immediately (add to set)
  - Unmatched '(' at end → Remove (left in stack after scan)
- **Why HashSet?**: O(1) lookup during result building
- **Example "lee(t(c)o)de)"**: Last ')' has no match → index 12 in removal set
- **Example "))(("**: All parentheses invalid → removal set {0,1,2,3} → empty result
- **StringBuilder**: Efficient string building (avoids string concatenation overhead)
- **Order Preserved**: Letters and valid parentheses maintain original order
- **Minimal Removal**: Only removes unmatched parentheses (minimum necessary)
- **Alternative**: Could use balance counter, but stack tracks exact indices needed


---

**Date Solved:** January 28, 2026  
**Review Count:** 0  
**Next Review:** January 28, 2026
