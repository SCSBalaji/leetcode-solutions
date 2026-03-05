# [1758]. Minimum Changes To Make Alternating Binary String

**Difficulty:** Easy  
**Topics:** `String`  
**Companies:** N/A  
**Link:** [Minimum Changes To Make Alternating Binary String](https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/)

---

## Problem Statement

You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.

The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.

Return the minimum number of operations needed to make s alternating.

**Example 1:**
```
Input: s = "0100"
Output: 1
Explanation: If you change the last character to '1', s will be "0101", which is alternating.
```

**Example 2:**
```
Input: s = "10"
Output: 0
Explanation: s is already alternating.
```

**Example 3:**
```
Input: s = "1111"
Output: 2
Explanation: You need two operations to reach "0101" or "1010".
```

**Constraints:**
- 1 <= s.length <= 104
- s[i] is either '0' or '1'.

---

## Solutions

### ⭐ Solution 1: Start with Zero or Start with One
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Track two counters: `start0` (changes for "010...") and `start1` (changes for "101...")
- Iterate through string:
  - Even indices: expect '0' for start0 pattern, '1' for start1 pattern
  - Odd indices: expect '1' for start0 pattern, '0' for start1 pattern
  - Increment respective counter when character doesn't match expected
- Return `Math.min(start0, start1)`


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

### ⭐ Solution 2: Only Check One
**File:** `Solution2.java`  
**Status:** ✅ Accepted

**Approach:**
- Count mismatches only for "010..." pattern (`start0`)
- The other pattern's cost = `n - start0` (complementary relationship)
- Return `Math.min(start0, n - start0)`


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Only Two Valid Patterns**: "010101..." or "101010..." (alternating always starts with 0 or 1)
- **Complementary Property**: Mismatches for pattern1 + mismatches for pattern2 = n
  - Every position is either correct for one pattern or the other, never both
- **Example "0100"**:
  - start0 (010...): pos 3 wrong → start0=1
  - start1 (101...): pos 0,2 wrong → n-start0=3
  - min(1,3) = 1 ✓
- **Example "1111"**:
  - start0 (010...): pos 0,2 wrong → start0=2
  - n-start0 = 4-2 = 2
  - min(2,2) = 2 ✓
- **Solution 2 Elegance**: Saves one counter using mathematical complement
- **Even/Odd Pattern**: Position parity determines expected character
  - Even positions: '0' for start0, '1' for start1
  - Odd positions: '1' for start0, '0' for start1


---

**Date Solved:** March 05, 2026  
**Review Count:** 0  
**Next Review:** March 05, 2026
