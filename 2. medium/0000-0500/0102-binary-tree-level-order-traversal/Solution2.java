import java.util.*;
// LeetCode #0102: Binary Tree Level Order Traversal
// Approach: Recusrion
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        recurse(root, 0, result);
        return result;
    }
    public static void recurse(TreeNode node, int level, List<List<Integer>> result) {
        if(node == null) {
            return;
        }
        if(result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        recurse(node.left, level + 1, result);
        recurse(node.right, level + 1, result);
    }
}