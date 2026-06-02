import java.util.*;
// LeetCode #0144: Binary Tree Preorder Traversal
// Approach: Recursion
// Status: ✅ Accepted
// Time: O(n)  |  Space: O(h)

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recurse(root, list);
        return list;
    }
    public void recurse(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        result.add(root.val);
        recurse(root.left, result);
        recurse(root.right, result);
    }
}