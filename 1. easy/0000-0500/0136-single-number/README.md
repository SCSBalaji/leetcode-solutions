# [0136]. Single Number

**Difficulty:** Easy  
**Topics:** `Array`, `Bit Manipulation`  
**Companies:** N/A  
**Link:** [Single Number](https://leetcode.com/problems/single-number/)

---

## Problem Statement

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

**Example 1:**
```
Input: nums = [2,2,1]

Output: 1
```

**Example 2:**
```
Input: nums = [4,1,2,1,2]

Output: 4
```

**Example 3:**
```
Input: nums = [1]

Output: 1
```

**Constraints:**
- 1 <= nums.length <= 3 * 104
- -3 * 104 <= nums[i] <= 3 * 104
- Each element in the array appears twice except for one element which appears only once.

---

## Solutions

### Solution 1: List Operation
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Use an ArrayList to track unique numbers
- For each number in array:
  - If not in list, add it
  - If already in list, remove it (found its pair)
- The remaining single element is the answer
- Uses list.contains() which requires O(n) search for each element


**Complexity:**
- ⏱️ Time: O(n²)
- 💾 Space: O(n)

---

### Solution 2: Hash Table
**File:** `Solution2.java`  
**Status:** ✅ Accepted

**Approach:**
- Use HashMap to count frequency of each number
- First pass: populate HashMap with counts using getOrDefault()
- Second pass: find and return the number with count == 1
- More efficient than Solution 1 due to O(1) HashMap lookups
 

**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

### Solution 3: Math
**File:** `Solution3.java`  
**Status:** ✅ Accepted

**Approach:**
- Use mathematical property: 2 * (sum of unique numbers) - (sum of all numbers) = single number
- Use HashSet to track unique numbers
- Calculate sumOfUnique (each unique number counted once)
- Calculate sumOfAll (includes duplicates)
- Formula: 2 * sumOfUnique - sumOfAll = single number
- Example: [4,1,2,1,2] → 2*(4+1+2) - (4+1+2+1+2) = 14 - 10 = 4


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

### ⭐ Solution 4: Bit Manipulation
**File:** `Solution4.java`  
**Status:** ✅ Accepted

**Approach:**
- Use XOR (^) operator properties:
  - a ^ a = 0 (any number XOR'd with itself is 0)
  - a ^ 0 = a (any number XOR'd with 0 is itself)
  - XOR is commutative and associative
- XOR all numbers together: pairs cancel out to 0, leaving only the single number
- Example: [4,1,2,1,2] → 4^1^2^1^2 = 4^(1^1)^(2^2) = 4^0^0 = 4
- **Most optimal solution** - meets both problem constraints (O(n) time, O(1) space)


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---


## Key Insights

- **Solution 1 (List)**: Intuitive but inefficient due to O(n) contains() operation
- **Solution 2 (HashMap)**: Standard approach with O(1) lookups, requires two passes
- **Solution 3 (Math)**: Clever mathematical approach, but requires integer overflow consideration
- **Solution 4 (XOR)**: Optimal solution using bit manipulation - satisfies problem's strict constraints
- XOR properties make it perfect for finding unpaired elements
- Only Solution 4 achieves O(1) space complexity as required by the problem
- All solutions except Solution 1 have O(n) time complexity
- Trade-off: Solution 4 is most efficient but least intuitive for beginners


---

**Date Solved:** January 12, 2026  
**Review Count:** 0  
**Next Review:** January 12, 2026
