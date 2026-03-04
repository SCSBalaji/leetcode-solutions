# [1672]. Richest Customer Wealth

**Difficulty:** Easy  
**Topics:** `Array`, `Matrix`  
**Companies:** N/A  
**Link:** [Richest Customer Wealth](https://leetcode.com/problems/richest-customer-wealth/)

---

## Problem Statement

You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

**Example 1:**
```
Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.
```

**Example 2:**
```
Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation: 
1st customer has wealth = 6
2nd customer has wealth = 10 
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.
```

**Example 3:**
```
Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
Output: 17
```

**Constraints:**
- m == accounts.length
- n == accounts[i].length
- 1 <= m, n <= 50
- 1 <= accounts[i][j] <= 100

---

## Solutions

### ⭐ Solution 1: Row Sum
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Initialize `maxWealth = 0`
- Outer loop: Iterate through each customer (row)
  - Initialize `sum = 0` for current customer
  - Inner loop: Sum all bank accounts (columns) for current customer
  - Update `maxWealth = Math.max(maxWealth, sum)`
- Return maximum wealth found


**Complexity:**
- ⏱️ Time: O(m × n)
- 💾 Space: O(1)

---

## Key Insights

- **2D Matrix Traversal**: Outer loop = customers (rows), inner loop = banks (columns)
- **Running Maximum**: Update max after each row sum (no need to store all sums)
- **Example [[1,2,3],[3,2,1]]**:
  - Row 0: 1+2+3 = 6, max=6
  - Row 1: 3+2+1 = 6, max=6
  - Result: 6 ✓
- **Example [[1,5],[7,3],[3,5]]**:
  - Row 0: 1+5 = 6, max=6
  - Row 1: 7+3 = 10, max=10
  - Row 2: 3+5 = 8, max=10
  - Result: 10 ✓
- **Redundant Variable**: `wealth = sum` is unnecessary, can directly use `sum`
- **Alternative**: Java Streams `Arrays.stream(row).sum()` for cleaner row sum
- **Constraint Leverage**: m,n ≤ 50, values ≤ 100 → max wealth = 50×100 = 5000 (no overflow)


---

**Date Solved:** March 04, 2026  
**Review Count:** 0  
**Next Review:** March 04, 2026
