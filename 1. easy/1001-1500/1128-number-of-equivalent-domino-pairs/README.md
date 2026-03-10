# [1128]. Number of Equivalent Domino Pairs

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`, `Counting`  
**Companies:** N/A  
**Link:** [Number of Equivalent Domino Pairs](https://leetcode.com/problems/number-of-equivalent-domino-pairs/)

---

## Problem Statement

Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

**Example 1:**
```
Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1
```

**Example 2:**
```
Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
Output: 3
```

**Constraints:**
- 1 <= dominoes.length <= 4 * 104
- dominoes[i].length == 2
- 1 <= dominoes[i][j] <= 9

---

## Solutions

### ⭐ Solution 1: Canonical Encoding + Frequency Count
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Use int array `num[100]` to store frequency of each canonical domino value
- For each domino `[a, b]`:
  - Normalize by encoding smaller value first: `val = min*10 + max`
  - Add `num[val]` to result (pairs with all previously seen equivalent dominoes)
  - Increment `num[val]`
- Return total pairs


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Canonical Form**: Always store `min(a,b)*10 + max(a,b)` → [1,2] and [2,1] both encode to `12`
- **Encoding Range**: Values 1-9, so max encoding = 99 → array size 100 sufficient
- **Counting Pairs On-The-Fly**: When processing element i, `num[val]` = count of equivalent elements seen before i → direct pair count
- **Why Add Before Increment**: If 3 equivalent dominoes exist [A,A,A], pairs = 0+1+2 = 3 = C(3,2) ✓
- **Example [[1,2],[2,1],[3,4],[5,6]]**:
  - [1,2] → val=12, ret+=0, num[12]=1
  - [2,1] → val=12, ret+=1, num[12]=2
  - Others: unique → ret stays 1 ✓
- **Example [[1,2],[1,2],[1,1],[1,2],[2,2]]**:
  - Three [1,2]s → 0+1+2=3 pairs ✓
- **Combinatorics**: n identical dominoes contribute C(n,2) = n*(n-1)/2 pairs (accumulated naturally)
- **No HashMap Needed**: Fixed digit range (1-9) allows direct array indexing


---

**Date Solved:** March 10, 2026  
**Review Count:** 0  
**Next Review:** March 10, 2026
