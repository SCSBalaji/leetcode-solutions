# [0696]. Count Binary Substrings

**Difficulty:** Easy  
**Topics:** `Two Pointers`, `String`  
**Companies:** N/A  
**Link:** [Count Binary Substrings](https://leetcode.com/problems/count-binary-substrings/)

---

## Problem Statement

Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

**Example 1:**
```
Input: s = "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
```

**Example 2:**
```
Input: s = "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
```

**Constraints:**
- 1 <= s.length <= 105
- s[i] is either '0' or '1'.

---

## Solutions

### Solution 1: Group By Character
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Create groups array to store consecutive character counts
- First pass: Group consecutive identical characters
  - When character changes, increment group index and reset count
  - When same character, increment current group count
- Second pass: Sum minimum of adjacent group pairs
  - Valid substrings = `min(groups[i-1], groups[i])` for each adjacent pair
- Return total count


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---


### ⭐ Solution 2: Linear Scan
**File:** `Solution2.java`  
**Status:** ✅ Accepted

**Approach:**
- Track `prev` (previous group size), `cur` (current group size), `ans` (answer)
- Iterate through string comparing adjacent characters:
  - If different: Add `min(prev, cur)` to answer, shift `prev=cur`, reset `cur=1`
  - If same: Increment `cur`
- After loop, add final pair: `min(prev, cur)`
- Return total count


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Core Observation**: Valid substrings form at boundaries between consecutive groups
- **Min Rule**: Between two groups of sizes a and b, can form `min(a, b)` valid substrings
  - Example: "000" (3 zeros) + "11" (2 ones) → min(3,2) = 2 substrings: "01", "0011"
- **Example "00110011"**:
  - Groups: [2,2,2,2] (00, 11, 00, 11)
  - Adjacent pairs: min(2,2)=2, min(2,2)=2, min(2,2)=2
  - Total: 2+2+2 = 6 ✓
- **Example "10101"**:
  - Groups: [1,1,1,1,1]
  - Adjacent pairs: min(1,1)=1 × 4 pairs
  - Total: 4 ✓
- **Why Min?**: Smaller group limits number of valid pairs
  - "000" + "1" → Only "01" valid (limited by single 1)
- **Solution 2 Advantage**: Space-optimized (no array), processes on-the-fly
- **Consecutive Requirement**: "0101" has groups [1,1,1,1], not [2,2] (alternating breaks groups)
- **Boundary Pairs**: Only adjacent groups form valid substrings (non-adjacent don't share boundary)


---

**Date Solved:** February 19, 2026  
**Review Count:** 0  
**Next Review:** February 19, 2026
