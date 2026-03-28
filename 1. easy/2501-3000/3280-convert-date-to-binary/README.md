# [3280]. Convert Date to Binary

**Difficulty:** Easy  
**Topics:** `Math`, `String`  
**Companies:** N/A  
**Link:** [Convert Date to Binary](https://leetcode.com/problems/convert-date-to-binary/)

---

## Problem Statement

You are given a string date representing a Gregorian calendar date in the yyyy-mm-dd format.

date can be written in its binary representation obtained by converting year, month, and day to their binary representations without any leading zeroes and writing them down in year-month-day format.

Return the binary representation of date.

**Example 1:**
```
Input: date = "2080-02-29"

Output: "100000100000-10-11101"

Explanation:

100000100000, 10, and 11101 are the binary representations of 2080, 02, and 29 respectively.
```

**Example 2:**
```
Input: date = "1900-01-01"

Output: "11101101100-1-1"

Explanation:

11101101100, 1, and 1 are the binary representations of 1900, 1, and 1 respectively.
```

**Constraints:**
- date.length == 10
- date[4] == date[7] == '-', and all other date[i]'s are digits.
- The input is generated such that date represents a valid Gregorian calendar date between Jan 1st, 1900 and Dec 31st, 2100 (both inclusive).

---

## Solutions

### ⭐ Solution 1: Split, Convert, Rebuild
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Split the date string by `-` into year, month, and day parts.
- Parse each part to integer (this removes any leading zeros naturally).
- Convert each integer to binary using `Integer.toBinaryString(...)`.
- Join the three binary strings with `-` in the same `year-month-day` order.


**Complexity:**
- ⏱️ Time: O(1)
- 💾 Space: O(1)

---

## Key Insights

- Parsing to integer automatically handles the “no leading zeroes” requirement in binary output.
- Each component (year, month, day) is converted independently, then recombined in original format.
- Fixed-size date format means both time and auxiliary space are constant.

---

**Date Solved:** March 28, 2026  
**Review Count:** 0  
**Next Review:** March 28, 2026
