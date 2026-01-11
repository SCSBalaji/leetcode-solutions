# [0027]. Remove Element

**Difficulty:** Easy  
**Topics:** `Array`, `Two Pointers`  
**Companies:** N/A  
**Link:** [Remove Element](https://leetcode.com/problems/remove-element/)

---

## Problem Statement

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

- Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
- Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

**Example 1:**
```
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
```

**Example 2:**
```
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).
```

**Constraints:**
- 0 <= nums.length <= 100
- 0 <= nums[i] <= 50
- 0 <= val <= 100

---

## Solutions

### ⭐ Solution 1: Two Pointers
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Use two pointers: `i` (write position) and `j` (read position)
- Iterate through array with `j`, when element is not equal to `val`, copy it to position `i`
- Increment `i` only when a valid element is copied
- Maintains relative order of elements


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

### ⭐ Solution 2: Two Pointers (Swap to End)
**File:** `Solution2.java`  
**Status:** ✅ Accepted

**Approach:**
- Use two pointers: `i` (current position) and `n` (array boundary)
- When `nums[i] == val`, swap with last element and shrink boundary (`n--`)
- Otherwise, move forward (`i++`)
- More efficient when elements to remove are rare (fewer assignments)
- Order is not preserved


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- Both solutions modify the array in-place with O(1) space
- Solution 1 preserves relative order of remaining elements
- Solution 2 is more efficient when `val` appears rarely (minimizes copy operations)
- Solution 2 may check some elements twice but does fewer assignments overall
- The problem allows changing element order, making Solution 2 viable
- Return value `k` represents the new length, elements beyond index `k` don't matter

---

**Date Solved:** January 11, 2026  
**Review Count:** 0  
**Next Review:** January 11, 2026
