# [3258]. Count Substrings That Satisfy K-Constraint I

**Difficulty:** Easy  
**Topics:** `String`, `Sliding Window`  
**Companies:** N/A  
**Link:** [Count Substrings That Satisfy K-Constraint I](https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/)

---

## Problem Statement

You are given a binary string s and an integer k.

A binary string satisfies the k-constraint if either of the following conditions holds:

- The number of 0's in the string is at most k.
- The number of 1's in the string is at most k.
Return an integer denoting the number of substrings of s that satisfy the k-constraint.

**Example 1:**
```
Input: s = "10101", k = 1

Output: 12

Explanation:

Every substring of s except the substrings "1010", "10101", and "0101" satisfies the k-constraint.
```

**Example 2:**
```
Input: s = "1010101", k = 2

Output: 25

Explanation:

Every substring of s except the substrings with a length greater than 5 satisfies the k-constraint.
```

**Example 3:**
```
Input: s = "11111", k = 1

Output: 15

Explanation:

All substrings of s satisfy the k-constraint.
```

**Constraints:**
- 1 <= s.length <= 50 
- 1 <= k <= s.length
- s[i] is either '0' or '1'.

---

## Solutions

### ⭐ Solution 1: Sliding Window with Invalid Substring Counting
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Calculate total possible substrings: `n × (n + 1) / 2`
- Use sliding window to count **invalid** substrings (violate k-constraint)
- Track counts of '0's and '1's in current window
- Expand right pointer and add characters to window
- When window becomes invalid (`zeros > k AND ones > k`):
  - Count invalid substrings starting at `left`: `n - right` (all extensions to the right)
  - Shrink window from left until valid again
- Return: `total - invalid`


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Inverse Counting**: Instead of counting valid substrings, count invalid ones and subtract from total
- **K-Constraint**: Valid if `zeros ≤ k OR ones ≤ k`; Invalid if `zeros > k AND ones > k`
- **Invalid Substring Pattern**: When window [left, right] becomes invalid, all substrings [left, x] where x ≥ right are invalid
  - Count = `n - right` substrings starting at current `left`
- **Why This Works**: Each time we shrink left, we've counted all invalid substrings starting at that left position
- **Example s="10101", k=1**:
  - Total substrings = 5×6/2 = 15
  - Invalid: "1010" (pos 0-3), "0101" (pos 1-4), "10101" (pos 0-4) = 3
  - Valid = 15 - 3 = 12 ✓
- **Total Formula**: n×(n+1)/2 counts all possible substrings (empty to full)
- **Long Cast**: Prevents overflow for large n (max: 50×51/2 = 1275, safe but good practice)
- **Sliding Window Efficiency**: Left pointer never resets, making it O(n) not O(n²)


---

**Date Solved:** February 09, 2026  
**Review Count:** 0  
**Next Review:** February 09, 2026
