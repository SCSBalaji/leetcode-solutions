# [1528]. Shuffle String

**Difficulty:** Easy  
**Topics:** `Array`, `String`  
**Companies:** N/A  
**Link:** [Shuffle String](https://leetcode.com/problems/shuffle-string/)

---

## Problem Statement

You are given a string s and an integer array indices of the same length. The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.

Return the shuffled string.

![Graph Example](./image.jpg)

**Example 1:**
```
Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
Output: "leetcode"
Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
```

**Example 2:**
```
Input: s = "abc", indices = [0,1,2]
Output: "abc"
Explanation: After shuffling, each character remains in its position.
```

**Constraints:**
- s.length == indices.length == n
- 1 <= n <= 100
- s consists of only lowercase English letters.
- 0 <= indices[i] < n
- All values of indices are unique.

---

## Solutions

### ⭐ Solution 1: Index Mapping with Array
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Create String array of size n to hold reordered characters
- Iterate through input string:
  - Place character at position i into arr[indices[i]]
  - Converts char to String using `String.valueOf(s.charAt(i))`
- Build result using StringBuilder by appending all array elements in order
- Return final string


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

## Key Insights

- **Reverse Mapping**: indices[i] tells where character at position i should go (not where it comes from)
- **Direct Placement**: No sorting needed, direct index mapping with single pass
- **Example "codeleet", indices=[4,5,6,7,0,2,1,3]**:
  - 'c' at pos 0 → arr[4] = "c"
  - 'o' at pos 1 → arr[5] = "o"
  - 'd' at pos 2 → arr[6] = "d"
  - 'e' at pos 3 → arr[7] = "e"
  - 'l' at pos 4 → arr[0] = "l"
  - 'e' at pos 5 → arr[2] = "e"
  - 'e' at pos 6 → arr[1] = "e"
  - 't' at pos 7 → arr[3] = "t"
  - Result: "leetcode" ✓
- **StringBuilder Efficiency**: Avoids string concatenation overhead (O(1) append vs O(n) concat)
- **String Array Choice**: Could use char[] instead for slight memory optimization
- **Unique Indices**: Guarantees no overwrites (each position filled exactly once)
- **Alternative**: char[] + direct assignment would be more efficient: `arr[indices[i]] = s.charAt(i)`


---

**Date Solved:** February 25, 2026  
**Review Count:** 0  
**Next Review:** February 25, 2026
