# [2125]. Number of Laser Beams in a Bank

**Difficulty:** Medium  
**Topics:** `Array`, `Math`, `String`, `Matrix`  
**Companies:** N/A  
**Link:** [Number of Laser Beams in a Bank](https://leetcode.com/problems/number-of-laser-beams-in-a-bank/)

---

## Problem Statement

Anti-theft security devices are activated inside a bank. You are given a 0-indexed binary string array bank representing the floor plan of the bank, which is an m x n 2D matrix. bank[i] represents the ith row, consisting of '0's and '1's. '0' means the cell is empty, while'1' means the cell has a security device.

There is one laser beam between any two security devices if both conditions are met:

- The two devices are located on two different rows: r1 and r2, where r1 < r2.
- For each row i where r1 < i < r2, there are no security devices in the ith row.
Laser beams are independent, i.e., one beam does not interfere nor join with another.

Return the total number of laser beams in the bank.

**Example 1:**
```
Input: bank = ["011001","000000","010100","001000"]
Output: 8
Explanation: Between each of the following device pairs, there is one beam. In total, there are 8 beams:
 * bank[0][1] -- bank[2][1]
 * bank[0][1] -- bank[2][3]
 * bank[0][2] -- bank[2][1]
 * bank[0][2] -- bank[2][3]
 * bank[0][5] -- bank[2][1]
 * bank[0][5] -- bank[2][3]
 * bank[2][1] -- bank[3][2]
 * bank[2][3] -- bank[3][2]
Note that there is no beam between any device on the 0th row with any on the 3rd row.
This is because the 2nd row contains security devices, which breaks the second condition.
```

![Graph Example](./example1.jpg)

**Example 2:**
```
Input: bank = ["000","111","000"]
Output: 0
Explanation: There does not exist two devices located on two different rows.
```

![Graph Example](./example2.jpg)

**Constraints:**
- m == bank.length
- n == bank[i].length
- 1 <= m, n <= 500
- bank[i][j] is either '0' or '1'.

---

## Solutions

### ⭐ Solution 1: Greedy
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Track `prev` = device count in previous non-empty row, `ans` = total beams
- Iterate through each row:
  - Count number of '1's (devices) in current row
  - If count > 0 (row has devices):
    - Add `prev × count` to answer (beams between previous and current row)
    - Update `prev = count` (current becomes previous for next iteration)
  - If count = 0: Skip row (doesn't affect beam calculation)
- Return total beams


**Complexity:**
- ⏱️ Time: O(m * n)
- 💾 Space: O(1)

---

## Key Insights

- **Core Formula**: Beams between two rows = `devices_in_row1 × devices_in_row2`
- **Key Observation**: Only adjacent non-empty rows form beams (empty rows are ignored)
- **Greedy Pattern**: Process rows sequentially, multiply consecutive device counts
- **Why Skip Empty Rows**: Condition requires no devices between beam endpoints
- **Example ["011001","000000","010100","001000"]**:
  - Row 0: 3 devices, prev=0 → ans += 0×3 = 0, prev=3
  - Row 1: 0 devices → skip (prev stays 3)
  - Row 2: 2 devices → ans += 3×2 = 6, prev=2
  - Row 3: 1 device → ans += 2×1 = 2, prev=1
  - Total: 8 beams
- **Multiplication Logic**: Each device in row i connects to each device in next non-empty row j
- **No Double Counting**: Only multiply forward (prev × current), not backward
- **Edge Case**: All empty rows or single row with devices → 0 beams
- **Alternative Counting**: Could store all non-zero counts then multiply pairs, but one-pass is more efficient


---

**Date Solved:** January 31, 2026  
**Review Count:** 0  
**Next Review:** January 31, 2026
