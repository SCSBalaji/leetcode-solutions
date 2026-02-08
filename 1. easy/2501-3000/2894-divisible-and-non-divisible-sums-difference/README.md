# [2894]. Divisible and Non-divisible Sums Difference

**Difficulty:** Easy  
**Topics:** `Math`  
**Companies:** N/A  
**Link:** [Divisible and Non-divisible Sums Difference](https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/)

---

## Problem Statement

You are given positive integers n and m.

Define two integers as follows:

- num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
- num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.
Return the integer num1 - num2.

**Example 1:**
```
Input: n = 10, m = 3
Output: 19
Explanation: In the given example:
- Integers in the range [1, 10] that are not divisible by 3 are [1,2,4,5,7,8,10], num1 is the sum of those integers = 37.
- Integers in the range [1, 10] that are divisible by 3 are [3,6,9], num2 is the sum of those integers = 18.
We return 37 - 18 = 19 as the answer.
```

**Example 2:**
```
Input: n = 5, m = 6
Output: 15
Explanation: In the given example:
- Integers in the range [1, 5] that are not divisible by 6 are [1,2,3,4,5], num1 is the sum of those integers = 15.
- Integers in the range [1, 5] that are divisible by 6 are [], num2 is the sum of those integers = 0.
We return 15 - 0 = 15 as the answer.
```

**Example 3:**
```
Input: n = 5, m = 1
Output: -15
Explanation: In the given example:
- Integers in the range [1, 5] that are not divisible by 1 are [], num1 is the sum of those integers = 0.
- Integers in the range [1, 5] that are divisible by 1 are [1,2,3,4,5], num2 is the sum of those integers = 15.
We return 0 - 15 = -15 as the answer.
```

**Constraints:**
- 1 <= n, m <= 1000

---

## Solutions

### ⭐ Solution 1: Traversal
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Initialize answer to 0
- Iterate from 1 to n:
  - If `i % m == 0`: Subtract i (divisible by m)
  - Else: Add i (not divisible by m)
- Return accumulated difference


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

### ⭐ Solution 2: Mathematical Derivation
**File:** `Solution2.java`  
**Status:** ✅ Accepted

**Approach:**
- Calculate `k = n / m` (count of multiples of m in range [1, n])
- Use formulas:
  - Total sum [1, n] = `n × (n + 1) / 2`
  - Sum of divisible numbers = `m × (1 + 2 + ... + k)` = `k × (k + 1) × m / 2`
- Return: Total sum - 2 × (sum of divisible)
  - Simplifies to: `n×(n+1)/2 - k×(k+1)×m`


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Mathematical Transformation**: 
  - `(sum_non_divisible) - (sum_divisible)` = `(total_sum - sum_divisible) - sum_divisible`
  - = `total_sum - 2×sum_divisible`
- **Arithmetic Progression**: Multiples of m form AP: m, 2m, 3m, ..., km
  - Sum = `m × (1+2+...+k)` = `m × k×(k+1)/2`
- **Example n=10, m=3**:
  - k = 10/3 = 3 (multiples: 3,6,9)
  - Total sum = 10×11/2 = 55
  - Divisible sum = 3×(1+2+3) = 18
  - Answer = 55 - 2×18 = 19 ✓
- **Example n=5, m=6**:
  - k = 5/6 = 0 (no multiples)
  - Total sum = 5×6/2 = 15
  - Answer = 15 - 0 = 15 ✓
- **Solution 2 Advantage**: O(1) vs O(n), crucial for large n (up to 1000)
- **Integer Division**: `k = n/m` automatically floors to count complete multiples


---

**Date Solved:** February 08, 2026  
**Review Count:** 0  
**Next Review:** February 08, 2026
