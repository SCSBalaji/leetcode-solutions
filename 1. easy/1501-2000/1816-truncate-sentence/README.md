# [1816]. Truncate Sentence

**Difficulty:** Easy  
**Topics:** `Array`, `String`  
**Companies:** N/A  
**Link:** [Truncate Sentence](https://leetcode.com/problems/truncate-sentence/)

---

## Problem Statement

A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each of the words consists of only uppercase and lowercase English letters (no punctuation).

For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.
You are given a sentence s​​​​​​ and an integer k​​​​​​. You want to truncate s​​​​​​ such that it contains only the first k​​​​​​ words. Return s​​​​​​ after truncating it.

**Example 1:**
```
Input: s = "Hello how are you Contestant", k = 4
Output: "Hello how are you"
Explanation:
The words in s are ["Hello", "how" "are", "you", "Contestant"].
The first 4 words are ["Hello", "how", "are", "you"].
Hence, you should return "Hello how are you".
```

**Example 2:**
```
Input: s = "What is the solution to this problem", k = 4
Output: "What is the solution"
Explanation:
The words in s are ["What", "is" "the", "solution", "to", "this", "problem"].
The first 4 words are ["What", "is", "the", "solution"].
Hence, you should return "What is the solution".
```

**Example 3:**
```
Input: s = "chopper is not a tanuki", k = 5
Output: "chopper is not a tanuki"
```

**Constraints:**
- 1 <= s.length <= 500
- k is in the range [1, the number of words in s].
- s consist of only lowercase and uppercase English letters and spaces.
- The words in s are separated by a single space.
- There are no leading or trailing spaces.

---

## Solutions

### ⭐ Solution 1: Iterative Space Counting
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Scan the sentence from left to right and count spaces.
- Each space marks the end of one word.
- As soon as the space count becomes k, return the substring from index 0 to the current index (exclusive).
- If the loop finishes, it means the sentence already has exactly k words, so return the whole string.


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- Truncating to first k words is equivalent to cutting at the k-th space.
- Because words are separated by a single space and there are no leading/trailing spaces, this index-based scan is enough.
- Early return avoids extra processing once the cut point is found.
- Time complexity is O(n), and extra space is O(1) (ignoring output string creation).

---

**Date Solved:** March 14, 2026  
**Review Count:** 0  
**Next Review:** March 14, 2026
