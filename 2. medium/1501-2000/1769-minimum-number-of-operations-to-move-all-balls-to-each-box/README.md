# [1769]. Minimum Number of Operations to Move All Balls to Each Box

**Difficulty:** Medium  
**Topics:** `Array`, `String`, `Prefix Sum`  
**Companies:** N/A  
**Link:** [Minimum Number of Operations to Move All Balls to Each Box](https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/)

---

## Problem Statement

You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.

In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.

Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.

Each answer[i] is calculated considering the initial state of the boxes.

**Example 1:**
```
Input: boxes = "110"
Output: [1,1,3]
Explanation: The answer for each box is as follows:
1) First box: you will have to move one ball from the second box to the first box in one operation.
2) Second box: you will have to move one ball from the first box to the second box in one operation.
3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
```

**Example 2:**
```
Input: boxes = "001011"
Output: [11,8,5,4,3,4]
```

**Constraints:**
- n == boxes.length
- 1 <= n <= 2000
- boxes[i] is either '0' or '1'.

---

## Solutions

### Solution 1: Brute Force
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Initialize result array `answer` of size n
- Outer loop: Iterate through each box position to find balls ('1')
- When a ball is found at position `currentBox`:
  - Inner loop: Iterate through all possible target positions
  - For each target position, add distance `Math.abs(newPosition - currentBox)` to answer array
  - Distance represents operations needed to move this ball to that position
- Each ball contributes its distance to every position in the answer array
- Simple but inefficient approach - calculates all distances independently


**Complexity:**
- ⏱️ Time: O(n^2)
- 💾 Space: O(1)

---

### ⭐ Solution 2: Sum of Left and Right Moves
**File:** `Solution2.java`  
**Status:** ✅ Accepted

**Approach:**
- **Key Insight**: Split problem into contributions from left and right balls
- Use 4 variables to track state:
  - `ballsToLeft`: Count of balls seen so far from left
  - `movesToLeft`: Total operations from left balls to current position
  - `ballsToRight`: Count of balls seen so far from right
  - `movesToRight`: Total operations from right balls to current position
- **Single pass** with dual pointer technique (i from left, j from right):
  - **Left pass** (index i, 0 → n-1):
    1. Add current `movesToLeft` to answer[i] (balls to left of i)
    2. If current position has ball, increment `ballsToLeft`
    3. Update `movesToLeft += ballsToLeft` (each left ball moves one step farther for next position)
  - **Right pass** (index j = n-1-i, n-1 → 0):
    1. Add current `movesToRight` to answer[j] (balls to right of j)
    2. If current position has ball, increment `ballsToRight`
    3. Update `movesToRight += ballsToRight` (each right ball moves one step farther for next position)
- Both passes happen simultaneously in one loop
- **Magic**: As we move right, each ball to the left needs one more operation; similarly for right balls


**Complexity:**
- ⏱️ Time: O(n^2)
- 💾 Space: O(1)

---

## Key Insights

- **Problem Pattern**: Classic prefix sum optimization problem
- **Solution 1**: Straightforward but inefficient - recalculates distances repeatedly
- **Solution 2**: Optimal - uses incremental tracking to avoid recalculation
- **Core Observation**: Total moves to position i = moves from left balls + moves from right balls
- **Incremental Update Pattern**:
  - When moving from position i to i+1, each ball to the left needs +1 operation
  - When moving from position i to i-1, each ball to the right needs +1 operation
- Example walkthrough for "110":
  - **Left pass**: 
    - i=0: movesToLeft=0, ballsToLeft becomes 1, movesToLeft becomes 1
    - i=1: answer[1]+=1, ballsToLeft becomes 2, movesToLeft becomes 3
    - i=2: answer[2]+=3
  - **Right pass**:
    - j=2: movesToRight=0, ballsToRight=0
    - j=1: answer[1]+=0, ballsToRight=1, movesToRight=1
    - j=0: answer[0]+=1, ballsToRight=2
  - Result: [1, 1, 3] ✓
- **Why it works**: We're building a running sum where each ball's contribution increases linearly with distance
- Solution 2 reduces time from O(n²) to O(n) - significant for n=2000
- The dual-pointer technique processes both directions simultaneously for efficiency
- Alternative: Could use three separate passes (left to right, right to left, combine) but this is more elegant
- Prefix sum concept: Each position accumulates contributions from previous positions incrementally


---

**Date Solved:** January 23, 2026  
**Review Count:** 0  
**Next Review:** January 23, 2026
