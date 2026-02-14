# [0799]. Champagne Tower

**Difficulty:** Medium  
**Topics:** `Dynamic Programming`  
**Companies:** N/A  
**Link:** [Champagne Tower](https://leetcode.com/problems/champagne-tower/)

---

## Problem Statement

We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.  Each glass holds one cup of champagne.

Then, some champagne is poured into the first glass at the top.  When the topmost glass is full, any excess liquid poured will fall equally to the glass immediately to the left and right of it.  When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on.  (A glass at the bottom row has its excess champagne fall on the floor.)

For example, after one cup of champagne is poured, the top most glass is full.  After two cups of champagne are poured, the two glasses on the second row are half full.  After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now.  After four cups of champagne are poured, the third row has the middle glass half full, and the two outside glasses are a quarter full, as pictured below.

![Graph Example](./tower.png)

Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is (both i and j are 0-indexed.)

**Example 1:**
```
Input: poured = 1, query_row = 1, query_glass = 1
Output: 0.00000
Explanation: We poured 1 cup of champange to the top glass of the tower (which is indexed as (0, 0)). There will be no excess liquid so all the glasses under the top glass will remain empty.
```

**Example 2:**
```
Input: poured = 2, query_row = 1, query_glass = 1
Output: 0.50000
Explanation: We poured 2 cups of champange to the top glass of the tower (which is indexed as (0, 0)). There is one cup of excess liquid. The glass indexed as (1, 0) and the glass indexed as (1, 1) will share the excess liquid equally, and each will get half cup of champange.
```

**Example 3:**
```
Input: poured = 100000009, query_row = 33, query_glass = 17
Output: 1.00000
```

**Constraints:**
- 0 <= poured <= 109
- 0 <= query_glass <= query_row < 100

---

## Solutions

### ⭐ Solution 1: Simulation 
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Create 2D array `A[102][102]` to represent champagne tower
- Pour all champagne into top glass: `A[0][0] = poured`
- Simulate overflow layer by layer up to `query_row`:
  - For each glass at position (r, c):
    - Calculate overflow: `q = (A[r][c] - 1.0) / 2.0`
    - If overflow exists (q > 0):
      - Pour half to left child: `A[r+1][c] += q`
      - Pour half to right child: `A[r+1][c+1] += q`
- Return `min(1.0, A[query_row][query_glass])` (cap at 1 cup)


**Complexity:**
- ⏱️ Time: O(query_row²)
- 💾 Space: O(1)

---

## Key Insights

- - **Physical Simulation**: Models real champagne overflow behavior (excess splits equally)
- **DP Pattern**: Each glass's amount depends on overflows from glasses above it
- **Overflow Formula**: `(amount - 1) / 2` gives excess per child (1 cup capacity)
- **Layer-by-Layer**: Process row-by-row ensures parent overflows before children receive
- **Early Termination**: Stop at `query_row`, no need to compute entire 100-row tower
- **Example poured=2, query=(1,1)**:
  - A[0][0] = 2.0 → overflow = (2-1)/2 = 0.5
  - A[1][0] += 0.5, A[1][1] += 0.5 → both get 0.5 ✓
- **Example poured=4**:
  - Row 0: A[0][0] = 4.0 → overflow 1.5 each
  - Row 1: A[1][0] = A[1][1] = 1.5 → overflow 0.25 each
  - Row 2: A[2][0] = 0.25, A[2][1] = 0.5 (gets from both), A[2][2] = 0.25 ✓
- **Capping at 1.0**: Prevents returning values > 1 for overfilled glasses
- **Zero Indexing**: query_row and query_glass are 0-indexed (top glass is (0,0))
- **Large Poured**: With 10⁹ cups, lower rows will be full (return 1.0)


---

**Date Solved:** February 14, 2026  
**Review Count:** 0  
**Next Review:** February 14, 2026
