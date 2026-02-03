# [3637]. Trionic Array I

**Difficulty:** Easy  
**Topics:** `Array`  
**Companies:** N/A  
**Link:** [Trionic Array I](https://leetcode.com/problems/trionic-array-i/)

---

## Problem Statement

You are given an integer array nums of length n.

An array is trionic if there exist indices 0 < p < q < n − 1 such that:

- nums[0...p] is strictly increasing,
- nums[p...q] is strictly decreasing,
- nums[q...n − 1] is strictly increasing.
Return true if nums is trionic, otherwise return false.

**Example 1:**
```
Input: nums = [1,3,5,4,2,6]

Output: true

Explanation:

Pick p = 2, q = 4:

- nums[0...2] = [1, 3, 5] is strictly increasing (1 < 3 < 5).
- nums[2...4] = [5, 4, 2] is strictly decreasing (5 > 4 > 2).
- nums[4...5] = [2, 6] is strictly increasing (2 < 6).
```

**Example 2:**
```
Input: nums = [2,1,3]

Output: false

Explanation:

There is no way to pick p and q to form the required three segments.
```

**Constraints:**
- 3 <= n <= 100
- -1000 <= nums[i] <= 1000

---

## Solutions

### ⭐ Solution 1: Evaluating the Validity of the Boundaries
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- **Phase 1 (Increasing)**: Advance while `nums[i-1] < nums[i]`, mark end as `p`
- **Phase 2 (Decreasing)**: Advance while `nums[i-1] > nums[i]`, mark end as `q`
- **Phase 3 (Increasing)**: Advance while `nums[i-1] < nums[i]`, mark end as `flag`
- **Validation**: Check if:
  - `p != 0` (first segment exists and is non-trivial)
  - `q != p` (second segment exists)
  - `flag == n-1` (reached end) AND `flag != q` (third segment exists)
- Return true if all conditions met


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

### ⭐ Solution 2: Counting the Number of Turning Points
**File:** `Solution2.java`  
**Status:** ✅ Accepted

**Approach:**
- **Initial Check**: If `nums[0] >= nums[1]`, return false (must start increasing)
- Initialize `count = 1` (first increasing segment started)
- Iterate from index 2:
  - If consecutive equal values found, return false (not strictly monotonic)
  - Detect direction change using product: `(nums[i-2] - nums[i-1]) × (nums[i-1] - nums[i]) < 0`
    - Negative product means sign change (turning point)
    - Increment `count` when turning point found
- Return `count == 3` (exactly 3 segments: up, down, up)


**Complexity:**
- ⏱️ Time: O(n)
- 💾 Space: O(1)

---

## Key Insights

- **Pattern**: Trionic = Mountain (up-down) + Valley (down-up) = exactly 2 turning points
- **Solution 1 Strategy**: Explicit boundary detection, intuitive but requires careful index validation
- **Solution 2 Strategy**: Count direction changes, elegant mathematical approach
- **Turning Point Math**: Product `(a-b)×(b-c) < 0` detects when slope changes sign
  - Positive product: same direction (both increasing or both decreasing)
  - Negative product: direction change (increasing→decreasing or vice versa)
- **Why count=3?**: 3 segments = 2 turning points, but initial increasing counts as 1
- **Edge Cases Handled**:
  - Equal consecutive values → false (not strictly monotonic)
  - Starting with decrease → false (must begin with increase)
  - Less than 3 segments → false (insufficient turning points)
- **Example [1,3,5,4,2,6]**: Turning points at indices 2 (↑→↓) and 4 (↓→↑) → count=3 ✓
- **Constraint Advantage**: n ≤ 100 makes both O(n) solutions very fast


---

**Date Solved:** February 03, 2026  
**Review Count:** 0  
**Next Review:** February 03, 2026
