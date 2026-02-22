# [0868]. Binary Gap

**Difficulty:** Easy  
**Topics:** `Bit Manipulation`  
**Companies:** N/A  
**Link:** [Binary Gap](https://leetcode.com/problems/binary-gap/)

---

## Problem Statement

Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n. If there are no two adjacent 1's, return 0.

Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The distance between two 1's is the absolute difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.

**Example 1:**
```
Input: n = 22
Output: 2
Explanation: 22 in binary is "10110".
The first adjacent pair of 1's is "10110" with a distance of 2.
The second adjacent pair of 1's is "10110" with a distance of 1.
The answer is the largest of these two distances, which is 2.
Note that "10110" is not a valid pair since there is a 1 separating the two 1's underlined.
```

**Example 2:**
```
Input: n = 8
Output: 0
Explanation: 8 in binary is "1000".
There are not any adjacent pairs of 1's in the binary representation of 8, so we return 0.
```

**Example 3:**
```
Input: n = 5
Output: 2
Explanation: 5 in binary is "101".
```

**Constraints:**
- 1 <= n <= 109

---

## Solutions

### ⭐ Solution 1: Store Indexes in Array
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Create array A[32] to store positions of all 1-bits
- First loop: Scan all 32 bits using right shift `(N >> i) & 1`
  - Store index i where bit is 1 into array
- Second loop: Calculate distances between consecutive 1-bit positions
  - Distance = `A[i+1] - A[i]`
  - Track maximum distance
- Return max distance (0 if less than two 1's)


**Complexity:**
- ⏱️ Time: O(log n)
- 💾 Space: O(log n)

---

### ⭐ Solution 2: One Pass
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Track `last` = position of previous 1-bit (initialize -1)
- Single loop through 32 bits:
  - Check if current bit is 1: `((N >> i) & 1) > 0`
  - If 1 found and `last >= 0`: Calculate distance `i - last`, update max
  - Update `last = i` for next iteration
- Return maximum distance


**Complexity:**
- ⏱️ Time: O(log n)
- 💾 Space: O(1)

---

## Key Insights

- **Bit Scanning**: `(N >> i) & 1` extracts bit at position i (0-indexed from right)
- **Distance Formula**: Between positions a and b, distance = |b - a| (always b - a since scanning left-to-right)
- **Adjacent Definition**: Consecutive 1's in bit positions, not necessarily consecutive bits
- **Example n=22 (10110)**:
  - 1-bit positions: [1, 2, 4] (indices from right)
  - Distances: 2-1=1, 4-2=2
  - Max: 2 ✓
- **Example n=8 (1000)**:
  - Only one 1-bit at position 3
  - No pairs → return 0 ✓
- **Example n=5 (101)**:
  - 1-bit positions: [0, 2]
  - Distance: 2-0=2 ✓
- **Solution 2 Advantage**: No array needed, processes on-the-fly
- **Edge Case**: Single 1-bit → last never updated twice → returns 0
- **Why 32 bits?**: Max n = 10⁹ fits in 30 bits, 32 covers all int values
- **First 1-bit**: When last=-1, skip distance calculation (need at least 2 for pair)


---

**Date Solved:** February 22, 2026  
**Review Count:** 0  
**Next Review:** February 22, 2026
