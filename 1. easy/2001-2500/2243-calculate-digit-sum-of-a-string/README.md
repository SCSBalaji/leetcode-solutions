# [2243]. Calculate Digit Sum of a String

**Difficulty:** Easy  
**Topics:** `String`, `Simulation`  
**Companies:** N/A  
**Link:** [Calculate Digit Sum of a String](https://leetcode.com/problems/calculate-digit-sum-of-a-string/)

---

## Problem Statement

You are given a string s consisting of digits and an integer k.

A round can be completed if the length of s is greater than k. In one round, do the following:

1. Divide s into consecutive groups of size k such that the first k characters are in the first group, the next k characters are in the second group, and so on. Note that the size of the last group can be smaller than k.
2. Replace each group of s with a string representing the sum of all its digits. For example, "346" is replaced with "13" because 3 + 4 + 6 = 13.
3. Merge consecutive groups together to form a new string. If the length of the string is greater than k, repeat from step 1.
Return s after all rounds have been completed.

**Example 1:**
```
Input: s = "11111222223", k = 3
Output: "135"
Explanation: 
- For the first round, we divide s into groups of size 3: "111", "112", "222", and "23".
  ​​​​​Then we calculate the digit sum of each group: 1 + 1 + 1 = 3, 1 + 1 + 2 = 4, 2 + 2 + 2 = 6, and 2 + 3 = 5. 
  So, s becomes "3" + "4" + "6" + "5" = "3465" after the first round.
- For the second round, we divide s into "346" and "5".
  Then we calculate the digit sum of each group: 3 + 4 + 6 = 13, 5 = 5. 
  So, s becomes "13" + "5" = "135" after second round. 
Now, s.length <= k, so we return "135" as the answer.
```

**Example 2:**
```
Input: s = "00000000", k = 3
Output: "000"
Explanation: 
We divide s into "000", "000", and "00".
Then we calculate the digit sum of each group: 0 + 0 + 0 = 0, 0 + 0 + 0 = 0, and 0 + 0 = 0. 
s becomes "0" + "0" + "0" = "000", whose length is equal to k, so we return "000".
```

**Constraints:**
- 1 <= s.length <= 100
- 2 <= k <= 100
- s consists of digits only.

---

## Solutions

### ⭐ Solution 1: Iterative Group Simulation
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Outer loop: Repeat while `s.length() > k`
- Each round:
  - Initialize empty result string `str`
  - Inner loop: Process groups of size k using pointer `i`
    - For each group, sum up to k digits using innermost loop
    - Append group sum as string to `str`
  - Replace `s = str` after each round
- Return `s` when length ≤ k


**Complexity:**
- ⏱️ Time: O(n²)
- 💾 Space: O(n)

---

## Key Insights

- **Simulation Pattern**: Directly simulate what the problem describes round by round
- **Three Nested Loops**: Outer (rounds) → Middle (groups) → Inner (digits in group)
- **Last Group Handling**: `while(x > 0 && i < n)` naturally handles smaller last group
- **Rapid Convergence**: String shrinks significantly each round (digits → their sums)
  - Max digits per sum ≤ 9×k, so string shrinks unless all digits are 0
- **Example "11111222223", k=3**:
  - Round 1: "111"→3, "112"→4, "222"→6, "23"→5 → s="3465"
  - Round 2: "346"→13, "5"→5 → s="135"
  - Length 3 = k → return "135" ✓
- **String Concatenation**: `str += ...` is O(n²) due to immutability; StringBuilder preferred
- **`charAt` to digit**: `Integer.parseInt(String.valueOf(s.charAt(i)))` works but `s.charAt(i) - '0'` is simpler
- **Constraint Leverage**: s.length ≤ 100 makes O(n²) string concatenation acceptable


---

**Date Solved:** March 08, 2026  
**Review Count:** 0  
**Next Review:** March 08, 2026
