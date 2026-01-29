# [3794]. Reverse String Prefix

**Difficulty:** Easy  
**Topics:** `String`, `Two Pointers`  
**Companies:** N/A  
**Link:** [Reverse String Prefix](https://leetcode.com/problems/reverse-string-prefix/)

---

## Problem Statement

You are given a string s and an integer k.

Reverse the first k characters of s and return the resulting string.

**Example 1:**
```
Input: s = "abcd", k = 2

Output: "bacd"

Explanation:​​​​​​​

The first k = 2 characters "ab" are reversed to "ba". The final resulting string is "bacd".
```

**Example 2:**
```
Input: s = "xyz", k = 3

Output: "zyx"

Explanation:

The first k = 3 characters "xyz" are reversed to "zyx". The final resulting string is "zyx".
```

**Example 3:**
```
Input: s = "hey", k = 1

Output: "hey"

Explanation:

The first k = 1 character "h" remains unchanged on reversal. The final resulting string is "hey".
```

**Constraints:**
- 1 <= s.length <= 100
- s consists of lowercase English letters.
- 1 <= k <= s.length

---

## Solutions

### ⭐ Solution 1: String Concatenation
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Initialize empty result string
- **First loop**: Iterate from index `k-1` down to `0` (reverse order)
  - Append each character to result string (reverses first k characters)
- **Second loop**: Iterate from index `k` to end of string
  - Append remaining characters in original order
- Return concatenated result string


**Complexity:**
- ⏱️ Time: O(n²)
- 💾 Space: O(n)

---

## Key Insights

- **Simple Two-Part Strategy**: Reverse prefix + keep suffix
- **Index Math**: First k chars are indices [0, k-1]; remaining are [k, n-1]
- **Example "abcd", k=2**: Reverse "ab"→"ba", keep "cd" → "bacd"
- **Edge Case k=1**: Single char unchanged (reverses to itself)
- **Edge Case k=n**: Entire string reversed
- **Performance Note**: String concatenation (`+=`) is O(n) per operation (creates new string)
  - Total: k + (n-k) iterations = n iterations × O(n) = O(n²)
- **Optimization**: Use `StringBuilder` for O(n) time instead
- **Alternative**: Convert to char array, use two pointers to swap in-place, then convert back
- **Constraint Impact**: Small n (≤100) makes O(n²) acceptable despite inefficiency


---

**Date Solved:** January 29, 2026  
**Review Count:** 0  
**Next Review:** January 29, 2026
