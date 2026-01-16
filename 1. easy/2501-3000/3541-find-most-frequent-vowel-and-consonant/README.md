# [3541]. Find Most Frequent Vowel and Consonant

**Difficulty:** Easy  
**Topics:** `Hash Table`, `String`, `Counting`  
**Companies:** N/A  
**Link:** [Find Most Frequent Vowel and Consonant](https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/)

---

## Problem Statement

You are given a string s consisting of lowercase English letters ('a' to 'z').

Your task is to:

- Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
- Find the consonant (all other letters excluding vowels) with the maximum frequency.
Return the sum of the two frequencies.

Note: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them. If there are no vowels or no consonants in the string, consider their frequency as 0.

The frequency of a letter x is the number of times it occurs in the string.

**Example 1:**
```
Input: s = "successes"

Output: 6

Explanation:

- The vowels are: 'u' (frequency 1), 'e' (frequency 2). The maximum frequency is 2.
- The consonants are: 's' (frequency 4), 'c' (frequency 2). The maximum frequency is 4.
- The output is 2 + 4 = 6.
```

**Example 2:**
```
Input: s = "aeiaeia"

Output: 3

Explanation:

- The vowels are: 'a' (frequency 3), 'e' ( frequency 2), 'i' (frequency 2). The maximum frequency is 3.
- There are no consonants in s. Hence, maximum consonant frequency = 0.
- The output is 3 + 0 = 3.
```

**Constraints:**
- 1 <= s.length <= 100
- s consists of lowercase English letters only.

---

## Solutions

### ⭐ Solution 1: Traversal
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Create HashMap to store frequency of each character in string
- First pass: Iterate through string and count frequency of each character using `getOrDefault()`
- Initialize two variables: `vowel` and `consonant` to track maximum frequencies
- Second pass: Iterate through all lowercase letters ('a' to 'z')
  - For each letter, check if it's a vowel using helper method
  - If vowel: update `vowel` with max of current max and this vowel's frequency
  - If consonant: update `consonant` with max of current max and this consonant's frequency
- Return sum of maximum vowel frequency and maximum consonant frequency
- Helper method `isVowel()` checks if character is one of 'a', 'e', 'i', 'o', 'u'


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- Problem requires finding max frequency among vowels and consonants separately
- Using HashMap provides O(1) lookup for character frequencies
- Two-pass approach: first count all frequencies, then find max for each category
- Iterating through 'a' to 'z' ensures we check all possible letters systematically
- `getOrDefault(ch, 0)` handles missing keys gracefully (returns 0 if character not in string)
- Helper method `isVowel()` provides clean separation of concerns
- Edge case: If no vowels exist, vowel frequency remains 0
- Edge case: If no consonants exist, consonant frequency remains 0
- Using `Math.max()` simplifies tracking maximum values
- Alternative approach: Could use two separate passes through the HashMap for vowels/consonants
- Space is O(1) because alphabet size is fixed (26 letters) regardless of input size
- Works efficiently with small constraint (n ≤ 100)


---

**Date Solved:** January 16, 2026  
**Review Count:** 0  
**Next Review:** January 16, 2026
