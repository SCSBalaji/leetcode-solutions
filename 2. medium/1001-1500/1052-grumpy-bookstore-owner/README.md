# [1052]. Grumpy Bookstore Owner

**Difficulty:** Medium  
**Topics:** `Array`, `Sliding Window`  
**Companies:** N/A  
**Link:** [Grumpy Bookstore Owner](https://leetcode.com/problems/grumpy-bookstore-owner/)

---

## Problem Statement

There is a bookstore owner that has a store open for n minutes. You are given an integer array customers of length n where customers[i] is the number of the customers that enter the store at the start of the ith minute and all those customers leave after the end of that minute.

During certain minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.

When the bookstore owner is grumpy, the customers entering during that minute are not satisfied. Otherwise, they are satisfied.

The bookstore owner knows a secret technique to remain not grumpy for minutes consecutive minutes, but this technique can only be used once.

Return the maximum number of customers that can be satisfied throughout the day.

**Example 1:**
```
Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3

Output: 16

Explanation:

The bookstore owner keeps themselves not grumpy for the last 3 minutes.

The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
```

**Example 2:**
```
Input: customers = [1], grumpy = [0], minutes = 1

Output: 1
```

**Constraints:**
- n == customers.length == grumpy.length
- 1 <= minutes <= n <= 2 * 104
- 0 <= customers[i] <= 1000
- grumpy[i] is either 0 or 1.

---

## Solutions

### ⭐ Solution 1: Sliding Window
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- **Key Insight**: Use the secret technique on the window of `minutes` consecutive minutes that saves the most unsatisfied customers
- Algorithm consists of three phases:

**Phase 1: Initialize first window (0 to minutes-1)**
- Calculate unsatisfied customers in first `minutes` window
- Formula: `customers[i] * grumpy[i]` (customers lost when grumpy)
- Store as initial `unsatisfied` count

**Phase 2: Slide window and find maximum recoverable customers (minutes to n-1)**
- Use sliding window technique to find optimal window placement
- For each new position:
  - Add new customer losses entering window: `customers[i] * grumpy[i]`
  - Remove old customer losses leaving window: `customers[i-minutes] * grumpy[i-minutes]`
  - Track maximum unsatisfied customers across all windows (`maxi`)
- This finds the window where technique saves most customers

**Phase 3: Calculate total satisfied customers**
- Start with `maxi` (customers saved by using technique optimally)
- Add all naturally satisfied customers: `customers[i] * (1 - grumpy[i])`
  - When `grumpy[i] = 0`: customers are satisfied (multiply by 1)
  - When `grumpy[i] = 1`: customers lost (multiply by 0, already counted in maxi)
- Return total


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Problem Pattern**: Fixed-size sliding window with optimization objective
- **Core Strategy**: Maximize impact of the one-time technique usage
- **Three-phase approach**: 
  1. Initialize window
  2. Find optimal window placement
  3. Calculate final result
- **Mathematical breakdown**:
  - Satisfied customers = `Σ customers[i] * (1 - grumpy[i])` (baseline)
  - Recoverable in window = `Σ customers[i] * grumpy[i]` for i in window
  - Total = baseline + max(recoverable)
- **Example walkthrough for customers=[1,0,1,2,1,1,7,5], grumpy=[0,1,0,1,0,1,0,1], minutes=3**:
  - Baseline satisfied (grumpy=0): 1+1+1+7 = 10
  - Window [0,2]: recoverable = 0*1 + 0*0 + 1*0 = 0
  - Window [1,3]: recoverable = 0*1 + 1*0 + 2*1 = 2
  - Window [2,4]: recoverable = 1*0 + 2*1 + 1*0 = 2
  - Window [3,5]: recoverable = 2*1 + 1*0 + 1*1 = 3
  - Window [4,6]: recoverable = 1*0 + 1*1 + 7*0 = 1
  - Window [5,7]: recoverable = 1*1 + 7*0 + 5*1 = 6 ✓ (maximum)
  - Total = 10 + 6 = 16
- **Smart multiplication tricks**:
  - `customers[i] * grumpy[i]`: Gets value only when grumpy (1), else 0
  - `customers[i] * (1 - grumpy[i])`: Gets value only when not grumpy (0), else 0
- **Edge case minutes=n**: Use technique for entire day (only one window)
- **Edge case minutes=1**: Find single minute with most grumpy customers
- Sliding window avoids recalculating entire window sum (O(1) per slide)
- The technique doesn't affect already satisfied customers (grumpy=0)
- Window size is fixed at `minutes`, classic fixed-size sliding window


---

**Date Solved:** January 26, 2026  
**Review Count:** 0  
**Next Review:** January 26, 2026
