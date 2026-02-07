# [3760]. Maximum Substrings With Distinct Start

**Difficulty:** Medium  
**Topics:** `String`, `Hash Table`  
**Companies:** N/A  
**Link:** [Maximum Substrings With Distinct Start](https://leetcode.com/problems/maximum-substrings-with-distinct-start/)

---

## Problem Statement

You are given a string s consisting of lowercase English letters.

Return an integer denoting the maximum number of substrings you can split s into such that each substring starts with a distinct character (i.e., no two substrings start with the same character).

**Example 1:**
```
Input: s = "abab"

Output: 2

Explanation:

- Split "abab" into "a" and "bab".
- Each substring starts with a distinct character i.e 'a' and 'b'. Thus, the answer is 2.
```

**Example 2:**
```
Input: s = "abcd"

Output: 4

Explanation:

- Split "abcd" into "a", "b", "c", and "d".
- Each substring starts with a distinct character. Thus, the answer is 4.
```

**Example 3:**
```
Input: s = "aaaa"

Output: 1

Explanation:

- All characters in "aaaa" are 'a'.
- Only one substring can start with 'a'. Thus, the answer is 1.
```

**Constraints:**
- 1 <= s.length <= 105
- s consists of lowercase English letters.

---

## Solutions

### ⭐ Solution 1: Hash Set
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Create HashSet to store unique characters
- Iterate through string and add each character to HashSet
- Return size of HashSet (number of distinct characters)


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Key Observation**: Maximum substrings = number of distinct characters in string
- **Greedy Principle**: To maximize splits, create smallest possible substrings (single characters when possible)
- **Why This Works**: Each distinct character can start exactly one substring
  - If 'a' appears multiple times, only first 'a' can be a split point
  - Subsequent 'a's must be part of longer substrings
- **Example "abab"**: Distinct chars = {a, b} → 2 splits: "a" + "bab"
- **Example "abcd"**: Distinct chars = {a, b, c, d} → 4 splits: "a" + "b" + "c" + "d"
- **Example "aaaa"**: Distinct chars = {a} → 1 split: "aaaa" (only one substring can start with 'a')
- **HashSet Property**: Automatically handles duplicates (only counts each character once)
- **Upper Bound**: Maximum possible answer is 26 (all lowercase letters present)
- **Problem Simplification**: Instead of finding actual splits, just count potential starting characters


---

**Date Solved:** February 07, 2026  
**Review Count:** 0  
**Next Review:** February 07, 2026
