# [0190]. Reverse Bits

**Difficulty:** Easy  
**Topics:** `Divide and Conquer`, `Bit Manipulation`  
**Companies:** N/A  
**Link:** [Reverse Bits](https://leetcode.com/problems/reverse-bits/)

---

## Problem Statement

Reverse bits of a given 32 bits signed integer.

**Example 1:**
```
Input: n = 43261596

Output: 964176192

Explanation:

| Integer   | Binary                               |
|-----------|---------------------------------------|
| 43261596  | 00000010100101000001111010011100      |
| 964176192 | 00111001011110000010100101000000      |

---

**Example 2:**
```
Input: n = 2147483644

Output: 1073741822

Explanation:

| Integer    | Binary                               |
|------------|---------------------------------------|
| 2147483644 | 01111111111111111111111111111100      |
| 1073741822 | 00111111111111111111111111111110      |

```

**Constraints:**
- 0 <= n <= 231 - 2
- n is even.

---

## Solutions

### ⭐ Solution 1: Bit-by-Bit Reversal with Shift Operations
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Initialize result = 0
- Loop 32 times (for each bit in 32-bit integer):
  - Left shift result by 1: `result <<= 1` (make space for new bit)
  - Extract LSB of n: `n & 1`
  - OR it into result: `result |= (n & 1)` (add bit to result)
  - Unsigned right shift n: `n >>>= 1` (move to next bit)
- Return reversed result


**Complexity:**
- ⏱️ Time: O(1)
- 💾 Space: O(1)

---

## Key Insights

- **Bit Extraction**: `n & 1` isolates the least significant bit (0 or 1)
- **Building Result**: Left shift creates empty slot, OR adds the bit
- **Unsigned Shift**: `>>>` fills with 0s (not sign bits), handles negative numbers correctly
- **Fixed Iterations**: Always 32 loops for 32-bit integer (not n-dependent)
- **Example n=43261596 (00000010100101000001111010011100)**:
  - Extract bits right-to-left: 0,0,1,1,1,0,0,1,0,1,1,1,1...
  - Build result left-to-right: Same bits reversed
  - Final: 964176192 (00111001011110000010100101000000) ✓
- **Process Visualization**:
  ```
  Iteration 1: result=0, n bit=0 → result=0
  Iteration 2: result=0, n bit=0 → result=0
  Iteration 3: result=0, n bit=1 → result=1
  ... (continue 32 times)
  ```
- **Why >>> not >>**: Regular >> propagates sign bit for negative numbers (incorrect reversal)
- **Bit Manipulation Combo**: Three operations work together (shift left, OR, shift right)
- **No Array/String**: Pure bitwise operations (memory efficient)


---

**Date Solved:** February 16, 2026  
**Review Count:** 0  
**Next Review:** February 16, 2026
