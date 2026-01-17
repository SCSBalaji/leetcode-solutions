# [2942]. Find Words Containing Character

**Difficulty:** Easy  
**Topics:** `Array`, `String`  
**Companies:** N/A  
**Link:** [Find Words Containing Character](https://leetcode.com/problems/find-words-containing-character/)

---

## Problem Statement

You are given a 0-indexed array of strings words and a character x.

Return an array of indices representing the words that contain the character x.

Note that the returned array may be in any order.

**Example 1:**
```
Input: words = ["leet","code"], x = "e"
Output: [0,1]
Explanation: "e" occurs in both words: "leet", and "code". Hence, we return indices 0 and 1.
```

**Example 2:**
```
Input: words = ["abc","bcd","aaaa","cbc"], x = "a"
Output: [0,2]
Explanation: "a" occurs in "abc", and "aaaa". Hence, we return indices 0 and 2.
```

**Example 3:**
```
Input: words = ["abc","bcd","aaaa","cbc"], x = "z"
Output: []
Explanation: "z" does not occur in any of the words. Hence, we return an empty array.
```

**Constraints:**
- 1 <= words.length <= 50
- 1 <= words[i].length <= 50
- x is a lowercase English letter.
- words[i] consists only of lowercase English letters.

---

## Solutions

### Solution 1: Brute Force
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Create ArrayList to store indices of words containing character x
- Outer loop: Iterate through each word in the words array
- Inner loop: Iterate through each character in current word
  - Use `charAt(j)` to check if current character matches x
  - If match found, add current word index i to list and break inner loop
  - Break ensures we don't add same index multiple times if x appears multiple times in word
- Return the list of indices


**Complexity:**
- ⏱️ Time: O(n * m)
- 💾 Space: O(k)

### ⭐ Solution 2: Simulation
**File:** `Solution2.java`  
**Status:** ✅ Accepted

**Approach:**
- Create ArrayList to store indices of words containing character x
- Iterate through each word in the words array
- Use built-in `indexOf(x)` method to check if character exists in word
  - `indexOf(x)` returns -1 if character not found, otherwise returns first occurrence index
  - If result is not -1, add current word index to list
- Return the list of indices
- More concise and idiomatic Java solution


**Complexity:**
- ⏱️ Time: O(n * m)
- 💾 Space: O(1)

---

## Key Insights

- Both solutions have same time complexity but different implementation styles
- **Solution 1**: Manual character-by-character comparison with explicit break
- **Solution 2**: Uses Java's built-in String method, cleaner and more readable
- `indexOf()` returns first occurrence index or -1, perfect for existence check
- Break statement in Solution 1 is crucial to avoid duplicate indices
- Order of returned indices doesn't matter per problem statement
- Edge case: Empty result list when no words contain x (Example 3)
- Space complexity excludes output space (result list) as it's required by problem
- With constraints (n ≤ 50, m ≤ 50), both solutions are efficient
- Solution 2 is preferred for production code due to readability and reliability
- Alternative: Could use Java 8 streams with `IntStream` and `filter()`


---

**Date Solved:** January 17, 2026  
**Review Count:** 0  
**Next Review:** January 17, 2026
