# [1009]. Complement of Base 10 Integer

**Difficulty:** Easy  
**Topics:** `Bit Manipulation`  
**Companies:** N/A  
**Link:** [Complement of Base 10 Integer](https://leetcode.com/problems/complement-of-base-10-integer/)

---

## Problem Statement

The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

- For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer n, return its complement.

**Example 1:**
```
Input: n = 5
Output: 2
Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
```

**Example 2:**
```
Input: n = 7
Output: 0
Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
```

**Example 3:**
```
Input: n = 10
Output: 5
Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
```

**Constraints:**
- 0 <= n < 109

---

## Solutions

### ⭐ Solution 1: Binary String Flip
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Convert `n` to binary string using `Integer.toBinaryString(n)`
- Iterate through each character:
  - If '1' → append '0'
  - If '0' → append '1'
- Parse flipped binary string back to int using `Integer.parseInt(sb.toString(), 2)`
- Return result


**Complexity:**
- ⏱️ Time: O(log n)
- 💾 Space: O(log n)

---

## Key Insights

- **No Leading Zeros**: `toBinaryString()` omits leading zeros, so complement doesn't add extra leading 1s
- **Example n=5 (101)**: Flip each bit → "010" → parseInt = 2 ✓
- **Example n=7 (111)**: Flip → "000" → parseInt = 0 ✓
- **Example n=10 (1010)**: Flip → "0101" → parseInt = 5 ✓
- **Edge Case n=0**: `toBinaryString(0)` = "0" → flip → "1" → return 1 ✓
- **Optimal Alternative**: XOR with bitmask `n ^ ((1 << bitLength) - 1)`
  - Create mask of all 1s same length as n's binary: `(1 << 30) - 1` won't work directly
  - Use `Integer.highestOneBit(n)` to find mask: `(highestOneBit(n) << 1) - 1`
  - Then `return n ^ mask` (pure bit manipulation, O(1))
- **Why This Works**: XOR with 1 flips a bit; XOR with mask of all 1s flips all bits in range


---

**Date Solved:** March 11, 2026  
**Review Count:** 0  
**Next Review:** March 11, 2026
