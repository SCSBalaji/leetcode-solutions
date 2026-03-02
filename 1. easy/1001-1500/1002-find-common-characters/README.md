# [1002]. Find Common Characters

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`, `String`  
**Companies:** N/A  
**Link:** [Find Common Characters](https://leetcode.com/problems/find-common-characters/)

---

## Problem Statement

Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

**Example 1:**
```
Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
```

**Example 2:**
```
Input: words = ["cool","lock","cook"]
Output: ["c","o"]
```

**Constraints:**
- 1 <= words.length <= 100
- 1 <= words[i].length <= 100
- words[i] consists of lowercase English letters.

---

## Solutions

### ⭐ Solution 1: Frequency Array Intersection
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Initialize `commonCharacterCounts[26]` with frequency of first word
- Iterate through remaining words:
  - Count frequencies of current word in `currentCharacterCounts[26]`
  - Take `Math.min()` of common and current counts for each letter (intersection)
- Build result list:
  - For each letter, add it `commonCharacterCounts[letter]` times to result
- Return result list


**Complexity:**
- ⏱️ Time: O(n × m)
- 💾 Space: O(1)

---

## Key Insights

- **Min Frequency = Common Characters**: Taking minimum across all words finds characters present in ALL words
- **First Word as Baseline**: Initialize with first word's frequency, then shrink via subsequent words
- **Example ["bella","label","roller"]**:
  - "bella": {b:1, e:1, l:2, a:1}
  - After "label": min → {b:1, e:1, l:2, a:1} ∩ {l:2, a:1, b:1, e:1} = {b:1, e:1, l:2, a:1}
  - After "roller": min → ∩ {r:2, o:1, l:2, e:1} = {e:1, l:2}
  - Result: ["e","l","l"] ✓
- **Example ["cool","lock","cook"]**:
  - Min across all: {c:1, o:1} → ["c","o"] ✓
- **Duplicates Handled**: Min count naturally handles duplicates ("l" appears twice in result)
- **Fixed 26**: Only lowercase letters → constant space regardless of input size
- **Arrays.fill()**: Reuses `currentCharacterCounts` array (avoids creating new array per word)
- **Why Min?**: If 'l' appears 3 times in word1 but 1 time in word2, max common is 1


---

**Date Solved:** March 02, 2026  
**Review Count:** 0  
**Next Review:** March 02, 2026
