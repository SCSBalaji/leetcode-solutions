# [3668]. Restore Finishing Order

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`  
**Companies:** N/A  
**Link:** [Restore Finishing Order](https://leetcode.com/problems/restore-finishing-order/)

---

## Problem Statement

You are given an integer array order of length n and an integer array friends.

- order contains every integer from 1 to n exactly once, representing the IDs of the participants of a race in their finishing order.
- friends contains the IDs of your friends in the race sorted in strictly increasing order. Each ID in friends is guaranteed to appear in the order array.
Return an array containing your friends' IDs in their finishing order.

**Example 1:**
```
Input: order = [3,1,2,5,4], friends = [1,3,4]

Output: [3,1,4]

Explanation:

The finishing order is [3, 1, 2, 5, 4]. Therefore, the finishing order of your friends is [3, 1, 4].
```

**Example 2:**
```
Input: order = [1,4,5,3,2], friends = [2,5]

Output: [5,2]

Explanation:

The finishing order is [1, 4, 5, 3, 2]. Therefore, the finishing order of your friends is [5, 2].
```

**Constraints:**
- 1 <= n == order.length <= 100
- order contains every integer from 1 to n exactly once
- 1 <= friends.length <= min(8, n)
- 1 <= friends[i] <= n
- friends is strictly increasing

---

## Solutions

### ⭐ Solution 1: Brute Force
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Create result array of size `friends.length` to store friends in finishing order
- Use index pointer starting at 0 to track position in result array
- Outer loop: Iterate through `order` array (finishing order of all participants)
- Inner loop: For each element in `order`, check if it exists in `friends` array
- If match found (`order[i] == friends[j]`):
  - Add that ID to result array at current index
  - Increment index pointer
  - Break inner loop to avoid checking remaining friends
- Return result array containing friends in their finishing order
- Simple two-pointer approach with nested loops


**Complexity:**
- ⏱️ Time: O(n * m)
- 💾 Space: O(m)

---

## Key Insights

- **Problem Essence**: Filter the order array to only include elements present in friends array
- **Solution 1**: Straightforward nested loop approach, easy to understand
- `friends` array is sorted, but we don't need to use that property here
- Break statement is crucial to avoid adding duplicates (though problem guarantees uniqueness)
- The order array is a permutation (all IDs from 1 to n exactly once)
- Small constraint on friends.length (≤ 8) makes brute force acceptable

---

**Date Solved:** January 22, 2026  
**Review Count:** 0  
**Next Review:** January 22, 2026
