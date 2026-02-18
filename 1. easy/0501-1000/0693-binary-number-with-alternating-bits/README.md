# [0693]. Binary Number with Alternating Bits

**Difficulty:** Easy  
**Topics:** `Bit Manipulation`  
**Companies:** N/A  
**Link:** [Binary Number with Alternating Bits](https://leetcode.com/problems/binary-number-with-alternating-bits/)

---

## Problem Statement

Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

**Example 1:**
```
Input: n = 5
Output: true
Explanation: The binary representation of 5 is: 101
```

**Example 2:**
```
Input: n = 7
Output: false
Explanation: The binary representation of 7 is: 111.
```

**Example 3:**
```
Input: n = 11
Output: false
Explanation: The binary representation of 11 is: 1011.
```

**Constraints:**
- 1 <= n <= 231 - 1

---

## Solutions

### ⭐ Solution 1: Convert to String
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Convert number to binary string using `Integer.toBinaryString(n)`
- Iterate through string checking adjacent characters
- If any two consecutive characters are equal, return false
- If loop completes without finding duplicates, return true


**Complexity:**
- ⏱️ Time: O(1)
- 💾 Space: O(1)

---

### ⭐ Solution 2: Divide By Two
**File:** `Solution2.java`  
**Status:** ✅ Accepted

**Approach:**
- Extract current LSB: `cur = n % 2`
- Divide n by 2 to shift to next bit
- Loop while n > 0:
  - Get next bit: `n % 2`
  - If next bit equals current bit, return false (not alternating)
  - Update current bit and continue dividing
- Return true if all bits alternate


**Complexity:**
- ⏱️ Time: O(1)
- 💾 Space: O(1)

---

## Key Insights

- **Alternating Pattern**: Valid numbers in binary: 10101...01 or 01010...10
- **Solution 1 Strategy**: String manipulation (readable, higher-level)
- **Solution 2 Strategy**: Pure bit manipulation (more efficient, no string allocation)
- **Example n=5 (binary: 101)**:
  - Sol 1: "101" → '1'≠'0'✓, '0'≠'1'✓ → true
  - Sol 2: cur=1, n=2 → next=0✓, cur=0, n=1 → next=1✓ → true
- **Example n=7 (binary: 111)**:
  - Sol 1: "111" → '1'=='1'✗ → false
  - Sol 2: cur=1, n=3 → next=1✗ → false
- **Modulo 2 Trick**: `n % 2` extracts LSB (0 or 1)
- **Division by 2**: Equivalent to right shift `n >> 1` but more readable
- **Solution 2 Advantage**: No string overhead, pure arithmetic operations
- **Valid Numbers**: 1(1), 2(10), 5(101), 10(1010), 21(10101), 42(101010), etc.
- **Constraint Impact**: n ≤ 2³¹-1 means at most 31 bits (both solutions O(1))


---

**Date Solved:** February 18, 2026  
**Review Count:** 0  
**Next Review:** February 18, 2026
