# [1935]. Maximum Number of Words You Can Type

**Difficulty:** Easy  
**Topics:** `Hash Table`, `String`  
**Companies:** N/A  
**Link:** [Maximum Number of Words You Can Type](https://leetcode.com/problems/maximum-number-of-words-you-can-type/)

---

## Problem Statement

There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.

Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.

**Example 1:**
```
Input: text = "hello world", brokenLetters = "ad"
Output: 1
Explanation: We cannot type "world" because the 'd' key is broken.
```

**Example 2:**
```
Input: text = "leet code", brokenLetters = "lt"
Output: 1
Explanation: We cannot type "leet" because the 'l' and 't' keys are broken.
```

**Example 3:**
```
Input: text = "leet code", brokenLetters = "e"
Output: 0
Explanation: We cannot type either word because the 'e' key is broken.
```

**Constraints:**
- 1 <= text.length <= 104
- 0 <= brokenLetters.length <= 26
- text consists of words separated by a single space without any leading or trailing spaces.
- Each word only consists of lowercase English letters.
- brokenLetters consists of distinct lowercase English letters.

---

## Solutions

### ⭐ Solution 1: Traversal + Hash Table
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Create HashSet from brokenLetters for O(1) lookup
- Initialize counter `res = 0` and flag `flag = true` (tracks if current word is typeable)
- Iterate through text character by character:
  - If space encountered:
    - If flag is true (word valid), increment counter
    - Reset flag to true for next word
  - If character is in broken set, mark flag as false
- After loop, check flag one more time (for last word without trailing space)
- Return total count


**Complexity:**
- ⏱️ Time: O(n + m)
- 💾 Space: O(m)

---

## Key Insights

- **Single Pass Strategy**: Process text once, count valid words on-the-fly
- **Flag Pattern**: Boolean tracks current word validity (reset at each space)
- **Space as Delimiter**: Marks word boundaries, triggers count increment
- **Final Word Check**: Last word has no trailing space, requires separate check after loop
- **Example "hello world", brokenLetters="ad"**:
  - "hello": All chars valid, flag=true at space → count=1
  - "world": 'd' in broken set, flag=false → count stays 1
  - Result: 1 ✓
- **Example "leet code", brokenLetters="e"**:
  - "leet": 'e' broken, flag=false → count=0
  - "code": 'e' broken, flag=false → count=0
  - Result: 0 ✓
- **HashSet Advantage**: O(1) contains() check vs O(m) string search
- **Early Invalidation**: Once broken letter found, no need to check rest of word
- **Empty brokenLetters**: All words counted (flag never set false)


---

**Date Solved:** February 27, 2026  
**Review Count:** 0  
**Next Review:** February 27, 2026
