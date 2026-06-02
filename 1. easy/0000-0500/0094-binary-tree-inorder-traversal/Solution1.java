import java.util.*;
// LeetCode #0094: Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recurse(root, result);
        return result;
    }
    public static void recurse(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        recurse(root.left, list);
        list.add(root.val);
        recurse(root.right, list);
    }
}