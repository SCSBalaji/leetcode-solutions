# [0888]. Fair Candy Swap

**Difficulty:** Easy  
**Topics:** `Array`, `Hash Table`, `Binary Search`, `Sorting`  
**Companies:** N/A  
**Link:** [Fair Candy Swap](https://leetcode.com/problems/fair-candy-swap/)

---

## Problem Statement

Alice and Bob have a different total number of candies. You are given two integer arrays aliceSizes and bobSizes where aliceSizes[i] is the number of candies of the ith box of candy that Alice has and bobSizes[j] is the number of candies of the jth box of candy that Bob has.

Since they are friends, they would like to exchange one candy box each so that after the exchange, they both have the same total amount of candy. The total amount of candy a person has is the sum of the number of candies in each box they have.

Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange, and answer[1] is the number of candies in the box that Bob must exchange. If there are multiple answers, you may return any one of them. It is guaranteed that at least one answer exists.

**Example 1:**
```
Input: aliceSizes = [1,1], bobSizes = [2,2]
Output: [1,2]
```

**Example 2:**
```
Input: aliceSizes = [1,2], bobSizes = [2,3]
Output: [1,2]
```

**Example 3:**
```
Input: aliceSizes = [2], bobSizes = [1,3]
Output: [2,3]
```

**Constraints:**
- 1 <= aliceSizes.length, bobSizes.length <= 104
- 1 <= aliceSizes[i], bobSizes[j] <= 105
- Alice and Bob have a different total number of candies.
- There will be at least one valid answer for the given input.

---

## Solutions

### ⭐ Solution 1: Math + HashSet Lookup
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Calculate `sumA` and `sumB` (total candies for Alice and Bob)
- Derive `diff = (sumA - sumB) / 2` (how much Alice's box must exceed Bob's box)
- Store all Bob's box sizes in HashSet for O(1) lookup
- Iterate through Alice's boxes:
  - For each box `x`, Bob's required box = `y = x - diff`
  - If `y` exists in Bob's HashSet → return `{x, y}`
- Return empty array (guaranteed answer exists so never reached)


**Complexity:**
- ⏱️ Time: O(n + m)
- 💾 Space: O(m)

---

## Key Insights

- **Mathematical Derivation**: After swap, Alice gives x, gets y:
  - `sumA - x + y = sumB - y + x`
  - Solving: `y = x - (sumA - sumB) / 2`
- **diff = (sumA - sumB) / 2**: The gap each swap must correct by half
- **Example [1,1], [2,2]**: sumA=2, sumB=4, diff=-1 → x=1, y=1-(-1)=2 → [1,2] ✓
- **Example [2], [1,3]**: sumA=2, sumB=4, diff=-1 → x=2, y=2-(-1)=3 → [2,3] ✓
- **Integer Division**: `(sumA - sumB)` always even (guaranteed by problem)
- **HashSet Advantage**: O(1) lookup vs O(m) linear search per Alice element
- **Any Valid Answer**: Return first match found (problem accepts any)
- **Alternative**: Sort both + binary search → O(n log n) but less elegant


---

**Date Solved:** March 09, 2026  
**Review Count:** 0  
**Next Review:** March 09, 2026
