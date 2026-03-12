# [1790]. Check if One String Swap Can Make Strings Equal

**Difficulty:** Easy  
**Topics:** `Hash Table`, `String`, `Counting`  
**Companies:** N/A  
**Link:** [Check if One String Swap Can Make Strings Equal](https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/)

---

## Problem Statement

You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.

**Example 1:**
```
Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".
```

**Example 2:**
```
Input: s1 = "attack", s2 = "defend"
Output: false
Explanation: It is impossible to make them equal with one string swap.
```

**Example 3:**
```
Input: s1 = "kelb", s2 = "kelb"
Output: true
Explanation: The two strings are already equal, so no string swap operation is required.
```

**Constraints:**
- 1 <= s1.length, s2.length <= 100
- s1.length == s2.length
- s1 and s2 consist of only lowercase English letters.

---

## Solutions

### ⭐ Solution 1: Difference Index Tracking
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Track `numDiffs`, `firstIndexDiff`, `secondIndexDiff`
- Single pass through both strings:
  - If characters differ, increment `numDiffs`
  - If `numDiffs > 2`: return false immediately (can't fix with one swap)
  - Record first and second differing indices
- Final check: verify swapping works:
  - `s1[first] == s2[second]` AND `s1[second] == s2[first]`
- Edge case: `numDiffs == 0` → strings already equal → final check passes (both indices = 0, same char)


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Valid Cases**:
  - 0 diffs → already equal (swap same index with itself)
  - 2 diffs → swap resolves both mismatches (cross-check required)
  - 1 diff → impossible (swapping can't fix odd number of mismatches)
- **Cross-Check**: At two diff positions i,j: need `s1[i]==s2[j]` AND `s1[j]==s2[i]`
- **Early Exit**: `numDiffs > 2` immediately returns false (optimization)
- **Example "bank","kanb"**: Diffs at 0('b'≠'k') and 3('k'≠'b') → s1[0]==s2[3] ('b'=='b') AND s1[3]==s2[0] ('k'=='k') → true ✓
- **Example "attack","defend"**: >2 diffs → false ✓
- **Example "kelb","kelb"**: 0 diffs → check s1[0]==s2[0] ('k'=='k') → true ✓
- **Why 1 diff fails**: One swap changes two positions; can't make equal with only one position different
- **numDiffs==0 Edge**: `firstIndexDiff=secondIndexDiff=0` → final check: `s1[0]==s2[0]` (true since no diff)


---

**Date Solved:** March 12, 2026  
**Review Count:** 0  
**Next Review:** March 12, 2026
