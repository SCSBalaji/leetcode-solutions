# [0001]. Two Sum

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`  
**Companies:** N/A  
**Link:** [Two Sum](https://leetcode.com/problems/two-sum/)

---

## Problem Statement

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

**Example 1:**
```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```

**Example 2:**
```
Input: nums = [3,2,4], target = 6
Output: [1,2] 
```

**Example 3:**
```
Input: nums = [3,3], target = 6
Output: [0,1]
```

**Constraints:**
- 2 <= nums.length <= 104
- -109 <= nums[i] <= 109
- -109 <= target <= 109
- Only one valid answer exists.

---

## Solutions

### Solution 1: Brute Force
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Used nested loops to check every pair of numbers
- For each element, iterate through remaining elements to find complement
- Return indices when sum equals target

**Complexity:**
- ⏱️ Time: O(n^2)
- 💾 Space: O(1)

---

### Solution 2: Brute Force (Optimized Check)
**File:** `Solution2.java`  
**Status:** ✅ Accepted

**Approach:**
- Similar to Solution 1 but calculates complement (target - nums[i]) first
- Slightly more readable by checking if nums[j] equals the complement
- Still uses nested loops for all pairs

**Complexity:**
- ⏱️ Time: O(n^2)
- 💾 Space: O(1)

---

### Solution 3: Two Pass Hash Table
**File:** `Solution3.java`  
**Status:** ✅ Accepted

**Approach:**
- First pass: Store all numbers and their indices in HashMap
- Second pass: For each number, check if complement exists in map
- Ensure we don't use the same element twice by checking index

**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

### ⭐ Solution 4: One Pass Hash Table
**File:** `Solution4.java`  
**Status:** ✅ Accepted

**Approach:**
- Combine both passes into one iteration
- For each element, check if complement already exists in map
- If found, return immediately; otherwise add current element to map
- Most efficient as it returns as soon as solution is found

**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

## Key Insights

- **Brute Force vs Hash Table**: Trading space for time - hash table solutions use O(n) space but reduce time from O(n²) to O(n)
- **One Pass Optimization**: Solution 4 is optimal because it eliminates the need to populate the entire hash map before searching
- **Early Return**: One pass approach can find the answer without processing all elements
- **Hash Table Benefits**: Provides O(1) lookup time for complement checking
- **Trade-offs**: For small arrays (n < 100), brute force might be faster due to no hash table overhead

---

**Date Solved:** January 10, 2026  
**Review Count:** 0  
**Next Review:** January 10, 2026
