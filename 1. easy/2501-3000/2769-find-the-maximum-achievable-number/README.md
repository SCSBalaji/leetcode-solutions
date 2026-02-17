# [2769]. Find the Maximum Achievable Number

**Difficulty:** Easy  
**Topics:** `Math`  
**Companies:** N/A  
**Link:** [Find the Maximum Achievable Number](https://leetcode.com/problems/find-the-maximum-achievable-number/)

---

## Problem Statement

Given two integers, num and t. A number x is achievable if it can become equal to num after applying the following operation at most t times:

- Increase or decrease x by 1, and simultaneously increase or decrease num by 1.
Return the maximum possible value of x.

**Example 1:**
```
Input: num = 4, t = 1

Output: 6

Explanation:

Apply the following operation once to make the maximum achievable number equal to num:

- Decrease the maximum achievable number by 1, and increase num by 1.
```

**Example 2:**
```
Input: num = 3, t = 2

Output: 7

Explanation:

Apply the following operation twice to make the maximum achievable number equal to num:

- Decrease the maximum achievable number by 1, and increase num by 1.
```

**Constraints:**
- 1 <= num, t <= 50

---

## Solutions

### ⭐ Solution 1: Math
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Return `num + 2 × t` directly (one-line formula)
- No iteration needed, pure mathematical calculation


**Complexity:**
- ⏱️ Time: O(1)
- 💾 Space: O(1)

---

## Key Insights

- **Key Observation**: To maximize x, always choose operations that increase both x and num
- **Optimal Strategy**: 
  - Start with maximum x
  - Each operation: Decrease x by 1, increase num by 1
  - After t operations: x decreased by t, num increased by t
  - Final equation: `x - t = num + t` → `x = num + 2t`
- **Why 2t?**: Each operation creates a gap of 2 between x and num (x down, num up)
- **Example num=4, t=1**:
  - Start: x=6, num=4 (gap=2)
  - Operation: x=5, num=5 (equal) ✓
  - Formula: 4 + 2×1 = 6 ✓
- **Example num=3, t=2**:
  - Start: x=7, num=3 (gap=4)
  - Op 1: x=6, num=4 (gap=2)
  - Op 2: x=5, num=5 (equal) ✓
  - Formula: 3 + 2×2 = 7 ✓
- **Greedy Insight**: Never decrease num or increase x (wastes operations)
- **No Edge Cases**: Formula works for all valid inputs (1 ≤ num, t ≤ 50)


---

**Date Solved:** February 17, 2026  
**Review Count:** 0  
**Next Review:** February 17, 2026
