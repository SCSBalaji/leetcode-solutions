# [1784]. Check if Binary String Has at Most One Segment of Ones

**Difficulty:** Easy  
**Topics:** `String`  
**Companies:** N/A  
**Link:** [Check if Binary String Has at Most One Segment of Ones](https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/)

---

## Problem Statement

Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains at most one contiguous segment of ones. Otherwise, return false.

**Example 1:**
```
Input: s = "1001"
Output: false
Explanation: The ones do not form a contiguous segment.
```

**Example 2:**
```
Input: s = "110"
Output: true
```

**Constraints:**
- 1 <= s.length <= 100
- s[i]​​​​ is either '0' or '1'.
- s[0] is '1'.

---

## Solutions

### ⭐ Solution 1: Pattern Detection
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Check if string contains substring "01"
- If "01" exists → return false (multiple segments of ones)
- If "01" absent → return true (at most one segment)
- Single line: `return !s.contains("01")`


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Core Observation**: "01" pattern means a '1' segment restarted after a '0' gap → two segments
- **No Leading Zeros**: `s[0]='1'` guaranteed, so string always starts with ones segment
- **Why "01" is Sufficient**: If ones never restart after a zero, string is valid
  - Valid: "111", "1100", "10000" (no "01" present)
  - Invalid: "1001", "10011" ("01" present → ones restarted)
- **Example "1001"**: Contains "01" (index 2-3) → false ✓
- **Example "110"**: No "01" pattern → true ✓
- **Example "1"**: No "01" pattern → true ✓
- **Elegant Reduction**: Complex segment-counting problem reduced to single substring check
- **Alternative**: Count transitions from '0'→'1', return true if count ≤ 1


---

**Date Solved:** March 06, 2026  
**Review Count:** 0  
**Next Review:** March 06, 2026
