# [1108]. Defanging an IP Address

**Difficulty:** Easy  
**Topics:** `String`  
**Companies:** N/A  
**Link:** [Defanging an IP Address](https://leetcode.com/problems/defanging-an-ip-address/)

---

## Problem Statement

Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".

**Example 1:**
```
Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"
```

**Example 2:**
```
Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"
```

**Constraints:**
- The given address is a valid IPv4 address.

---

## Solutions

### Solution 1: StringBuilder Iteration
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Create a StringBuilder to efficiently build the result string
- Convert input string to character array using `toCharArray()`
- Iterate through each character in the address
- If character is a period ('.'), append "[.]" to StringBuilder
- Otherwise, append the character as-is
- Convert StringBuilder to String and return
- Uses StringBuilder for O(1) amortized append operations
- Most explicit and educational approach


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

### ⭐ Solution 2: Built-In Replace
**File:** `Solution2.java`  
**Status:** ✅ Accepted

**Approach:**
- Use Java's built-in `replace(CharSequence target, CharSequence replacement)` method
- Single line solution: `address.replace(".", "[.]")`
- Replaces all occurrences of "." with "[.]" in one operation
- Most concise and readable solution
- Internally uses similar logic to Solution 1 but optimized at JVM level
- No need for manual character iteration


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

### Solution 3: Regular Expression
**File:** `Solution3.java`  
**Status:** ✅ Accepted

**Approach:**
- Use `replaceAll(String regex, String replacement)` with regex pattern
- Pattern: `"\\."` - Escaped period (. is special char in regex, needs escaping)
- Replaces all matches with "[.]"
- More powerful than replace() as it supports pattern matching
- Overkill for this simple problem but demonstrates regex capability
- Slightly slower due to regex compilation overhead


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(n)

---

## Key Insights

- All three solutions have same time/space complexity but different implementation styles
- **Solution 1**: Most verbose, good for learning, shows manual string building
- **Solution 2**: Optimal choice - simple, readable, efficient, no regex overhead
- **Solution 3**: Demonstrates regex but unnecessary complexity for literal replacement
- `replace()` is preferred over `replaceAll()` for literal string replacement (no regex needed)
- IPv4 addresses have exactly 3 periods, so output is always input length + 6
- `replaceAll()` requires escaping special regex characters: `\\.` for literal period
- StringBuilder vs String concatenation: StringBuilder is O(n), concatenation is O(n²)
- Problem guarantees valid IPv4, so no validation or error handling needed
- Example transformation: "1.1.1.1" (7 chars) → "1[.]1[.]1[.]1" (13 chars)
- For production code: Use Solution 2 (built-in replace) for best balance of simplicity and performance


---

**Date Solved:** January 18, 2026  
**Review Count:** 0  
**Next Review:** January 18, 2026
