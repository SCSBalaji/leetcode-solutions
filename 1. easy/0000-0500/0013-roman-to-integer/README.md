# [0013]. Roman to Integer

**Difficulty:** Easy  
**Topics:** `Hash Table`, `Math`, `String`  
**Companies:** N/A  
**Link:** [Roman to Integer](https://leetcode.com/problems/roman-to-integer/)

---

## Problem Statement

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

**Example 1:**
```
Input: s = "III"
Output: 3
Explanation: III = 3.
```

**Example 2:**
```
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
```

**Example 3:**
```
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```

**Constraints:**
- 1 <= s.length <= 15
- s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
- It is guaranteed that s is a valid roman numeral in the range [1, 3999].

---

## Solutions

### ⭐ Solution 1: Left to Right pass
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Use a HashMap to store Roman numeral values
- Iterate through string from left to right
- Look ahead to next character - if current value < next value, subtract current from next (handle subtraction cases like IV, IX)
- Otherwise, add current value to sum
- Skip ahead by 2 when handling subtraction cases, by 1 otherwise


**Complexity:**
- ⏱️ Time: O(1)
- 💾 Space: O(1)

---

### ⭐ Solution 2: Left To Right Pass Improved
**File:** `Solution2.java`  
**Status:** ✅ Accepted

**Approach:**
- Extend HashMap to include all 6 subtraction cases (IV, IX, XL, XC, CD, CM)
- Iterate through string from left to right
- Check if next 2 characters form a valid subtraction pair first
- If yes, add that value and skip 2 positions
- If no, add single character value and skip 1 position
- Eliminates need for comparison logic


**Complexity:**
- ⏱️ Time: O(1)
- 💾 Space: O(1)

---

### ⭐ Solution 3: Right To Left Pass
**File:** `Solution3.java`  
**Status:** ✅ Accepted

**Approach:**
- Use a HashMap to store Roman numeral values
- Start from rightmost character and move left
- Keep track of last processed value
- If current value < last value, subtract it (handles subtraction cases automatically)
- Otherwise, add current value to total
- Most elegant solution - subtraction cases handled implicitly


**Complexity:**
- ⏱️ Time: O(1)
- 💾 Space: O(1)

---

## Key Insights

- All solutions have O(1) complexity because input is constrained to maximum 15 characters
- Solution 1: Explicit lookahead for subtraction cases
- Solution 2: Pre-compute subtraction pairs for cleaner code
- Solution 3: Most elegant - right-to-left scan naturally handles subtraction without special cases
- Negative numbers never appear in valid Roman numerals
- The subtraction rule only applies to specific pairs (I before V/X, X before L/C, C before D/M)


---

**Date Solved:** January 12, 2026  
**Review Count:** 0  
**Next Review:** January 12, 2026
