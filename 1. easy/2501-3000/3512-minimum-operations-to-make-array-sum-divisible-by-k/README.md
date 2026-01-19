# [3512]. Minimum Operations to Make Array Sum Divisible by K

**Difficulty:** Easy  
**Topics:** `Array`, `Math`  
**Companies:** N/A  
**Link:** [Minimum Operations to Make Array Sum Divisible by K](https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/)

---

## Problem Statement

You are given an integer array nums and an integer k. You can perform the following operation any number of times:

- Select an index i and replace nums[i] with nums[i] - 1.
Return the minimum number of operations required to make the sum of the array divisible by k.

**Example 1:**
```
Input: nums = [3,9,7], k = 5

Output: 4

Explanation:

- Perform 4 operations on nums[1] = 9. Now, nums = [3, 5, 7].
- The sum is 15, which is divisible by 5.
```

**Example 2:**
```
Input: nums = [4,1,3], k = 4

Output: 0

Explanation:

- The sum is 8, which is already divisible by 4. Hence, no operations are needed.
```

**Example 3:**
```
Input: nums = [3,2], k = 6

Output: 5

Explanation:

- Perform 3 operations on nums[0] = 3 and 2 operations on nums[1] = 2. Now, nums = [0, 0].
- The sum is 0, which is divisible by 6.
```

**Constraints:**
- 1 <= nums.length <= 1000
- 1 <= nums[i] <= 1000
- 1 <= k <= 100

---

## Solutions

### ⭐ Solution 1: Sum Modulo
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Calculate the sum of all elements in the array
- Find the remainder when sum is divided by k using modulo operator (sum % k)
- The remainder represents how many operations are needed to make sum divisible by k
- Each operation decrements an element by 1, reducing total sum by 1
- Therefore, we need exactly (sum % k) operations to reach nearest divisible sum
- If sum is already divisible by k, remainder is 0 (no operations needed)
- Mathematical insight: We only care about the remainder, not which elements to modify


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Core Mathematical Principle**: If sum ≡ r (mod k), we need exactly r operations to make sum divisible by k
- Problem reduces to simple modulo arithmetic - no need to track individual elements
- Each decrement operation reduces sum by 1, so we can choose any elements to modify
- Example 1: sum = 19, k = 5 → 19 % 5 = 4 operations needed → new sum = 15 (divisible by 5)
- Example 2: sum = 8, k = 4 → 8 % 4 = 0 operations needed (already divisible)
- Example 3: sum = 5, k = 6 → 5 % 6 = 5 operations needed → new sum = 0 (divisible by 6)
- Greedy approach works: doesn't matter which elements we decrement, total operations remain same
- We can never need more than k-1 operations (remainder is always less than divisor)
- Alternative perspective: Finding smallest non-negative number to subtract from sum to reach divisibility
- Edge case: If sum < k and not divisible, we decrement to 0 (always divisible by any k)
- Modulo operation naturally handles all edge cases
- This is purely a math problem disguised as an array problem


---

**Why This Works:**

For any sum S and divisor k:
- S = q × k + r, where 0 ≤ r < k (Division Algorithm)
- r = S % k is the remainder
- To make S divisible by k, we need S - r ≡ 0 (mod k)
- Each operation reduces sum by 1, so r operations make sum = q × k
- Therefore, minimum operations = r = S % k

---

**Date Solved:** January 19, 2026  
**Review Count:** 0  
**Next Review:** January 19, 2026
