# [3315]. Construct the Minimum Bitwise Array II

**Difficulty:** Easy  
**Topics:** `Array`, `Bit Manipulation`  
**Companies:** N/A  
**Link:** [Construct the Minimum Bitwise Array II](https://leetcode.com/problems/construct-the-minimum-bitwise-array-ii/)

---

## Problem Statement

You are given an array nums consisting of n prime integers.

You need to construct an array ans of length n, such that, for each index i, the bitwise OR of ans[i] and ans[i] + 1 is equal to nums[i], i.e. ans[i] OR (ans[i] + 1) == nums[i].

Additionally, you must minimize each value of ans[i] in the resulting array.

If it is not possible to find such a value for ans[i] that satisfies the condition, then set ans[i] = -1.

**Example 1:**
```
Input: nums = [2,3,5,7]

Output: [-1,1,4,3]

Explanation:

- For i = 0, as there is no value for ans[0] that satisfies ans[0] OR (ans[0] + 1) = 2, so ans[0] = -1.
- For i = 1, the smallest ans[1] that satisfies ans[1] OR (ans[1] + 1) = 3 is 1, because 1 OR (1 + 1) = 3.
- For i = 2, the smallest ans[2] that satisfies ans[2] OR (ans[2] + 1) = 5 is 4, because 4 OR (4 + 1) = 5.
- For i = 3, the smallest ans[3] that satisfies ans[3] OR (ans[3] + 1) = 7 is 3, because 3 OR (3 + 1) = 7.
```

**Example 2:**
```
Input: nums = [11,13,31]

Output: [9,12,15]

Explanation:

- For i = 0, the smallest ans[0] that satisfies ans[0] OR (ans[0] + 1) = 11 is 9, because 9 OR (9 + 1) = 11.
- For i = 1, the smallest ans[1] that satisfies ans[1] OR (ans[1] + 1) = 13 is 12, because 12 OR (12 + 1) = 13.
- For i = 2, the smallest ans[2] that satisfies ans[2] OR (ans[2] + 1) = 31 is 15, because 15 OR (15 + 1) = 31.
```

**Constraints:**
- 1 <= nums.length <= 100
- 2 <= nums[i] <= 109
- nums[i] is a prime number.

---

## Solutions

### ⭐ Solution 1: Bitwise Operation
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- For each number x in nums, we need to find ans such that: `ans OR (ans + 1) = x`
- **Key Observation**: When we add 1 to a number, it flips the rightmost 0 bit to 1 and all 1s to its right become 0
- Example: 9 (1001) + 1 = 10 (1010) → flips bit at position 1
- The OR operation will set all bits that are 1 in either operand
- **Algorithm**:
  - Initialize result to -1 (for impossible cases)
  - Use bitmask `d` starting at 1 (checking LSB first)
  - While current bit in x is 1 (using `x & d`):
    - Try `ans = x - d` (turn off that bit)
    - Shift d left (`d <<= 1`) to check next bit
  - If we find a 0 bit before checking all bits, last computed `x - d` is the answer
  - If x has all bits as 1 (like 2 = 10 in binary, only has one 1), return -1
- **Why this works**: We're finding the rightmost 0 bit in x's binary representation and subtracting the corresponding power of 2


**Complexity:**
- ⏱️ Time: O(n log m)
- 💾 Space: O(1)

---

## Key Insights

- **Core Pattern**: `ans OR (ans + 1) = x` means x must have a specific bit pattern
- When adding 1 to a number, binary addition causes a "carry chain" until hitting a 0 bit
- Example walkthrough for x = 11 (binary: 1011):
  - Check bit 0 (d=1): 1011 & 0001 = 1 → try 11-1=10 → shift d
  - Check bit 1 (d=2): 1011 & 0010 = 1 → try 11-2=9 → shift d
  - Check bit 2 (d=4): 1011 & 0100 = 0 → stop, answer is 9
  - Verify: 9 (1001) OR 10 (1010) = 1011 = 11 ✓
- **Why x=2 returns -1**: 2 in binary is 10 (only one 1 bit), no 0 bit to flip before it
- For prime numbers specifically:
  - If prime is even (only 2), impossible → return -1
  - Odd primes have at least one 0 bit in their binary representation (works)
- The algorithm finds the **rightmost 0 bit** and clears the bit to its right
- Pattern: ans = x - (smallest power of 2 where x has a 0 bit)
- Alternative perspective: We're removing the rightmost consecutive 1s in x's binary form
- Example: 7 (111) → 3 (011): removed rightmost 1, result is 3 OR 4 = 7
- Example: 13 (1101) → 12 (1100): removed bit at position 0, result is 12 OR 13 = 13
- The loop continues while encountering 1s, stops at first 0 bit
- If all bits are 1 until we run out (like powers of 2), no solution exists


---

**Date Solved:** January 21, 2026  
**Review Count:** 0  
**Next Review:** January 21, 2026
