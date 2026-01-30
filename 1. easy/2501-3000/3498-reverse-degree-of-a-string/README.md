# [3498]. Reverse Degree of a String

**Difficulty:** Easy  
**Topics:** `String`, `Simulation`  
**Companies:** N/A  
**Link:** [Reverse Degree of a String](https://leetcode.com/problems/reverse-degree-of-a-string/)

---

## Problem Statement

Given a string s, calculate its reverse degree.

The reverse degree is calculated as follows:

1. For each character, multiply its position in the reversed alphabet ('a' = 26, 'b' = 25, ..., 'z' = 1) with its position in the string (1-indexed).
2. Sum these products for all characters in the string.
Return the reverse degree of s.

**Example 1:**
```
Input: s = "abc"

Output: 148

Explanation:

Letter	    Index in Reversed Alphabet	    Index in String	    Product
'a'	                26	                            1	            26
'b'	                25	                            2	            50
'c'	                24	                            3	            72
The reversed degree is 26 + 50 + 72 = 148.
```

**Example 2:**
```
Input: s = "zaza"

Output: 160

Explanation:

Letter	    Index in Reversed Alphabet	    Index in String	    Product
'z'	                1	                            1	            1
'a'	                26	                            2	            52
'z'	                1	                            3	            3
'a'	                26	                            4	            104
The reverse degree is 1 + 52 + 3 + 104 = 160.
```

**Constraints:**
- 1 <= s.length <= 1000
- s contains only lowercase English letters.

---

## Solutions

### ⭐ Solution 1: Single Pass with Formula
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Initialize sum to 0
- Iterate through string with index i (0-indexed)
- For each character at position i:
  - Calculate reversed alphabet position: `26 - (s.charAt(i) - 'a')`
    - 'a' → 26 - 0 = 26, 'b' → 26 - 1 = 25, ..., 'z' → 26 - 25 = 1
  - Multiply by 1-indexed string position: `(i + 1)`
  - Add product to sum
- Return total sum


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Formula Breakdown**: `(26 - (char - 'a')) × (index + 1)`
  - Reversed alphabet: 'a'=26, 'z'=1 (inverse of normal a=1, z=26)
  - String position: 1-indexed (add 1 to loop index)
- **Character Math**: `s.charAt(i) - 'a'` converts char to 0-25 offset
- **Example "abc"**: (26×1) + (25×2) + (24×3) = 26 + 50 + 72 = 148
- **Example "zaza"**: (1×1) + (26×2) + (1×3) + (26×4) = 1 + 52 + 3 + 104 = 160
- **No Preprocessing**: Direct calculation in single loop (no arrays needed)
- **Accumulator Pattern**: Running sum updated each iteration
- **ASCII Offset**: Subtracting 'a' normalizes lowercase letters to 0-25 range
- **Constraint Impact**: n ≤ 1000 means O(n) is very efficient


---

**Date Solved:** January 30, 2026  
**Review Count:** 0  
**Next Review:** January 30, 2026
