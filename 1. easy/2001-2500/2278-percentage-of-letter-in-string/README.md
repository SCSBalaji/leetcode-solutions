# [2278]. Percentage of Letter in String

**Difficulty:** Easy  
**Topics:** `String`  
**Companies:** N/A  
**Link:** [Percentage of Letter in String](https://leetcode.com/problems/percentage-of-letter-in-string/)

---

## Problem Statement

Given a string s and a character letter, return the percentage of characters in s that equal letter rounded down to the nearest whole percent.

**Example 1:**
```
Input: s = "foobar", letter = "o"
Output: 33
Explanation:
The percentage of characters in s that equal the letter 'o' is 2 / 6 * 100% = 33% when rounded down, so we return 33.
```

**Example 2:**
```
Input: s = "jjjj", letter = "k"
Output: 0
Explanation:
The percentage of characters in s that equal the letter 'k' is 0%, so we return 0.
```

**Constraints:**
- 1 <= s.length <= 100
- s consists of lowercase English letters.
- letter is a lowercase English letter.

---

## Solutions

### ⭐ Solution 1: Frequency Array Counting
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Create an integer array of size 26 to store character frequencies.
- Traverse string `s` once and increment count for each character.
- Get frequency of `letter` from the array.
- Compute percentage using integer math: `(count * 100) / s.length()`.
- Integer division automatically gives floor value as required.


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- Since input is lowercase English letters only, a fixed-size 26 array is enough.
- No floating-point calculation is needed; integer division already performs round-down.
- Direct indexing (`ch - 'a'`) makes counting efficient and simple.

---

**Date Solved:** March 22, 2026  
**Review Count:** 0  
**Next Review:** March 22, 2026
