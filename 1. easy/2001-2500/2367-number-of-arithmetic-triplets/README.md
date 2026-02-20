# [2367]. Number of Arithmetic Triplets

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`, `Two Pointers`, `Enumeration`  
**Companies:** N/A  
**Link:** [Number of Arithmetic Triplets](https://leetcode.com/problems/number-of-arithmetic-triplets/)

---

## Problem Statement

You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:

- i < j < k,
- nums[j] - nums[i] == diff, and
- nums[k] - nums[j] == diff.
Return the number of unique arithmetic triplets.

**Example 1:**
```
Input: nums = [0,1,4,6,7,10], diff = 3
Output: 2
Explanation:
(1, 2, 4) is an arithmetic triplet because both 7 - 4 == 3 and 4 - 1 == 3.
(2, 4, 5) is an arithmetic triplet because both 10 - 7 == 3 and 7 - 4 == 3. 
```

**Example 2:**
```
Input: nums = [4,5,6,7,8,9], diff = 2
Output: 2
Explanation:
(0, 2, 4) is an arithmetic triplet because both 8 - 6 == 2 and 6 - 4 == 2.
(1, 3, 5) is an arithmetic triplet because both 9 - 7 == 2 and 7 - 5 == 2.
```

**Constraints:**
- 3 <= nums.length <= 200
- 0 <= nums[i] <= 200
- 1 <= diff <= 50
- nums is strictly increasing.

---

## Solutions

### ⭐ Solution 1: Triple Nested Loop Enumeration
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Use three nested loops to check all possible triplets (i, j, k)
- Outer loop (i): First element position [0, m-3]
- Middle loop (j): Second element position [i+1, m-2]
  - Check if `nums[j] - nums[i] == diff`, else continue
- Inner loop (k): Third element position [j+1, m-1]
  - Check if `nums[k] - nums[j] == diff`, increment count if true
- Return total count


**Complexity:**
- ⏱️ Time: O(n³)
- 💾 Space: O(1)

---

## Key Insights

- **Arithmetic Triplet Condition**: Both differences must equal `diff`: `b-a = c-b = diff`
- **Strictly Increasing**: Guarantees i < j < k indices automatically (no duplicate checking)
- **Early Continue**: Skip middle loop iteration if `nums[j] - nums[i] ≠ diff` (optimization)
- **Example [0,1,4,6,7,10], diff=3**:
  - (1,4,7): 4-1=3✓, 7-4=3✓ → count=1
  - (4,7,10): 7-4=3✓, 10-7=3✓ → count=2
  - Total: 2 ✓
- **Example [4,5,6,7,8,9], diff=2**:
  - (4,6,8): 6-4=2✓, 8-6=2✓ → count=1
  - (5,7,9): 7-5=2✓, 9-7=2✓ → count=2
  - Total: 2 ✓
- **Constraint Leverage**: n ≤ 200 makes O(n³) acceptable (~8M operations max)
- **Optimization Possible**: HashSet O(n) solution exists (check if `nums[i]+diff` and `nums[i]+2×diff` exist)
- **No Duplicates**: Strictly increasing ensures unique triplets (no repeated values)


---

**Date Solved:** February 20, 2026  
**Review Count:** 0  
**Next Review:** February 20, 2026
