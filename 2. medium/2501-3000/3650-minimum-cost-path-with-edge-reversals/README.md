# [3650]. Minimum Cost Path with Edge Reversals

**Difficulty:** Medium  
**Topics:** `Graph Theory`, `Heap`, `Shortest Path`  
**Companies:** N/A  
**Link:** [Minimum Cost Path with Edge Reversals](https://leetcode.com/problems/minimum-cost-path-with-edge-reversals/)

---

## Problem Statement

You are given a directed, weighted graph with n nodes labeled from 0 to n - 1, and an array edges where edges[i] = [ui, vi, wi] represents a directed edge from node ui to node vi with cost wi.

Each node ui has a switch that can be used at most once: when you arrive at ui and have not yet used its switch, you may activate it on one of its incoming edges vi → ui reverse that edge to ui → vi and immediately traverse it.

The reversal is only valid for that single move, and using a reversed edge costs 2 * wi.

Return the minimum total cost to travel from node 0 to node n - 1. If it is not possible, return -1.

**Example 1:**
```
Input: n = 4, edges = [[0,1,3],[3,1,1],[2,3,4],[0,2,2]]

Output: 5

Explanation:


- Use the path 0 → 1 (cost 3).
- At node 1 reverse the original edge 3 → 1 into 1 → 3 and traverse it at cost 2 * 1 = 2.
- Total cost is 3 + 2 = 5.
```
![Graph Example](./graph.png)

**Example 2:**
```
Input: n = 4, edges = [[0,2,1],[2,1,1],[1,3,1],[2,3,3]]

Output: 3

Explanation:

- No reversal is needed. Take the path 0 → 2 (cost 1), then 2 → 1 (cost 1), then 1 → 3 (cost 1).
- Total cost is 1 + 1 + 1 = 3.
```

**Constraints:**
- 2 <= n <= 5 * 104
- 1 <= edges.length <= 105
- edges[i] = [ui, vi, wi]
- 0 <= ui, vi <= n - 1
- 1 <= wi <= 1000

---

## Solutions

### ⭐ Solution 1: Dijkstra
**File:** `Solution1.java`  
**Status:** ✅ Accepted

**Approach:**
- Transform directed graph into bidirectional by adding reverse edges with doubled cost
- For each edge `u → v` with weight `w`:
  - Keep original: `u → v` (cost `w`)
  - Add reverse: `v → u` (cost `2w`) to simulate switch usage
- Apply standard Dijkstra's algorithm from node 0 to find shortest path to n-1
- Use priority queue (min-heap) to greedily select minimum distance node
- Early termination when destination (n-1) is reached
- Return -1 if destination unreachable


**Complexity:**
- ⏱️ Time: O(n + m log m)
- 💾 Space: O(n + m)

---

## Key Insights

- **Problem Transformation**: Model edge reversal as adding reverse edges with penalty cost (2×)
- **Why Dijkstra?**: Non-negative weights, need single-source shortest path
- **Cost Structure**: Normal edge = w, reversed edge = 2w (penalty discourages unnecessary reversals)
- **Switch Constraint**: Implicitly handled by cost structure (algorithm naturally minimizes)
- **Early Exit**: Stop immediately when destination reached (no need to compute all distances)
- **Example 1**: Path 0→1(3) + 1→3 reverse(2) = 5 beats 0→2→3(6)
- **Example 2**: Direct path 0→2→1→3(3) optimal, no reversals needed
- **Edge Cases**: Return -1 if no path exists (queue empties)
- **Why Not BFS/DFS?**: Weighted graph requires cost-aware pathfinding
- **Graph Doubles**: Original m edges become 2m edges after transformation


---

**Date Solved:** January 27, 2026  
**Review Count:** 0  
**Next Review:** January 27, 2026
