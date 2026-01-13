# [1929]. Concatenation of Array

**Difficulty:** Easy  
**Topics:** `Array`, `Simulation`  
**Companies:** N/A  
**Link:** [Concatenation of Array](https://leetcode.com/problems/concatenation-of-array/)

---

## Problem Statement

Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.

**Example 1:**
```
Input: nums = [1,2,1]
Output: [1,2,1,1,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
- ans = [1,2,1,1,2,1]
```

**Example 2:**
```
Input: nums = [1,3,2,1]
Output: [1,3,2,1,1,3,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
- ans = [1,3,2,1,1,3,2,1]
```

**Constraints:**
- n == nums.length
- 1 <= n <= 1000
- 1 <= nums[i] <= 1000

---

## Solutions

### ⭐ Solution 1: Simple Iteration
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Create new array of size 2n
- Single loop through original array (0 to n-1)
- For each index i:
  - Set res[i] = nums[i] (first half)
  - Set res[i + n] = nums[i] (second half)
- Both copies happen in one pass
- Most straightforward and readable approach


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

### ⭐ Solution 2: Built-In Array Copy
**File:** `Solution2.java`  
**Status:** ✅ Accepted

**Approach:**
- Create new array of size 2n
- Use System.arraycopy() twice:
  - First call: Copy nums to res[0...n-1] (first half)
  - Second call: Copy nums to res[n...2n-1] (second half)
- System.arraycopy() is a native method, typically faster than manual loops
- More concise than Solution 1


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

### ⭐ Solution 3: CopyOf with Built-In Array Copy
**File:** `Solution3.java`  
**Status:** ✅ Accepted

**Approach:**
- Use Arrays.copyOf() to create new array of size 2n with first n elements copied
- Arrays.copyOf() internally allocates new array and copies elements
- Then use System.arraycopy() once to copy nums to second half
- Slightly different strategy: allocate + copy first half in one step
- Most concise solution


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

## Key Insights

- All three solutions have identical time and space complexity
- **Solution 1**: Most readable and explicit about what's happening
- **Solution 2**: Uses standard library methods, potentially faster in practice
- **Solution 3**: Most concise, combines allocation and first copy
- System.arraycopy() and Arrays.copyOf() are native methods, usually faster than manual loops
- The problem is straightforward - main difference is coding style preference
- All solutions avoid modifying the input array
- Performance differences in practice are negligible for constraints (n ≤ 1000)
- Choose Solution 1 for clarity, Solution 2/3 for using Java idioms


---

**Date Solved:** January 13, 2026  
**Review Count:** 0  
**Next Review:** January 13, 2026
