# [3304]. Find the K-th Character in String Game I

**Difficulty:** Easy  
**Topics:** `Math`, `Bit Manipulation`, `Recursion`, `Simulation`  
**Companies:** N/A  
**Link:** [Find the K-th Character in String Game I](https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/)

---

## Problem Statement

Alice and Bob are playing a game. Initially, Alice has a string word = "a".

You are given a positive integer k.

Now Bob will ask Alice to perform the following operation forever:

- Generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word.
For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".

Return the value of the kth character in word, after enough operations have been done for word to have at least k characters.

**Example 1:**
```
Input: k = 5

Output: "b"

Explanation:

Initially, word = "a". We need to do the operation three times:

- Generated string is "b", word becomes "ab".
- Generated string is "bc", word becomes "abbc".
- Generated string is "bccd", word becomes "abbcbccd".
```

**Example 2:**
```
Input: k = 10

Output: "c"
```

**Constraints:**
- 1 <= k <= 500

---

## Solutions

### ⭐ Solution 1: Iteration
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Track position mutations by decomposing k into powers of 2
- Initialize `ans = 0` (tracks character offset from 'a')
- While k ≠ 1:
  - Find highest set bit position: `t = 31 - Integer.numberOfLeadingZeros(k)`
  - If k is exactly a power of 2 (`(1 << t) == k`), decrement t
  - Subtract that power of 2 from k: `k -= (1 << t)`
  - Increment `ans` (each subtraction represents one character shift)
- Return `'a' + ans` (character at final offset)


**Complexity:**
- ⏱️ Time: O(log k)
- 💾 Space: O(1)

---

## Key Insights

- **Pattern Recognition**: String growth follows binary tree structure (doubles each operation)
- **Binary Decomposition**: Position k can be reached by following binary path
- **Power of 2 Handling**: If k is exactly 2^t, use 2^(t-1) instead (boundary case)
- **Character Offset**: Each power-of-2 step increments the character by 1
- **Example k=5 (binary: 101)**:
  - Initial: k=5, ans=0
  - t=2 (bit position), not power of 2 → k = 5-4 = 1, ans=1
  - Loop ends, return 'a'+1 = 'b' ✓
- **Example k=10 (binary: 1010)**:
  - t=3, not power of 2 → k = 10-8 = 2, ans=1
  - t=1, is power of 2 → t=0, k = 2-1 = 1, ans=2
  - Return 'a'+2 = 'c' ✓
- **Leading Zeros Trick**: `31 - Integer.numberOfLeadingZeros(k)` finds MSB position efficiently
- **Bit Shift**: `(1 << t)` computes 2^t without Math.pow
- **No String Building**: Avoids generating actual string (memory efficient)


---

**Date Solved:** February 11, 2026  
**Review Count:** 0  
**Next Review:** February 11, 2026
