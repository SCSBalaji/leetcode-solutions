# [3713]. Longest Balanced Substring I

**Difficulty:** Medium  
**Topics:** `String`, `Hash Table`, `Counting`, `Enumeration`  
**Companies:** N/A  
**Link:** [Longest Balanced Substring I](https://leetcode.com/problems/longest-balanced-substring-i/)

---

## Problem Statement

You are given a string s consisting of lowercase English letters.

A substring of s is called balanced if all distinct characters in the substring appear the same number of times.

Return the length of the longest balanced substring of s.

**Example 1:**
```
Input: s = "abbac"

Output: 4

Explanation:

The longest balanced substring is "abba" because both distinct characters 'a' and 'b' each appear exactly 2 times.
```

**Example 2:**
```
Input: s = "zzabccy"

Output: 4

Explanation:

The longest balanced substring is "zabc" because the distinct characters 'z', 'a', 'b', and 'c' each appear exactly 1 time.​​​​​​​
```

**Example 3:**
```
Input: s = "aba"

Output: 2

Explanation:

​​​​​​​One of the longest balanced substrings is "ab" because both distinct characters 'a' and 'b' each appear exactly 1 time. Another longest balanced substring is "ba".
```

**Constraints:**
- 1 <= s.length <= 1000
- s consists of lowercase English letters.

---

## Solutions

### ⭐ Solution 1: Enumeration
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Use nested loops to check all possible substrings
- Outer loop (i): Starting position
- Inner loop (j): Extending position from i
- For each substring [i, j]:
  - Maintain frequency array `cnt[26]` for character counts
  - Add character at j to frequency array
  - Check if balanced: All non-zero counts must equal the last added character's count
  - If balanced, update max length
  - Reset frequency array for each new starting position i
- Return maximum balanced length found


**Complexity:**
- ⏱️ Time: O(n²)
- 💾 Space: O(1)

---

## Key Insights

- **Balanced Definition**: All distinct characters appear with same frequency
- **Incremental Validation**: Check balance after each character addition (early detection)
- **Frequency Invariant**: If balanced, all non-zero counts equal the most recently added character's count
- **Example "abbac"**:
  - Substring "abba": cnt[a]=2, cnt[b]=2 → all equal → length 4 ✓
  - "abbac": cnt[a]=3, cnt[b]=2, cnt[c]=1 → not equal → invalid
- **Example "zzabccy"**: 
  - "zabc": cnt[z]=1, cnt[a]=1, cnt[b]=1, cnt[c]=1 → all 1 → length 4 ✓
- **Single Character**: Always balanced (frequency = 1)
- **Optimization**: Early break when non-equal frequencies detected (flag = false)
- **Array Reset**: `Arrays.fill(cnt, 0)` clears frequencies for each new start position
- **Constraint Impact**: n ≤ 1000 makes O(n²) acceptable (~1M operations)


---

**Date Solved:** February 12, 2026  
**Review Count:** 0  
**Next Review:** February 12, 2026
