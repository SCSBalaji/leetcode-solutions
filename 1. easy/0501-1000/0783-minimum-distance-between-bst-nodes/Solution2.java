import java.util.*;
// LeetCode #0783: Minimum Distance Between Bst Nodes
// Approach: Inorder Into List + Linear Scan
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
    public int minDiffInBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrder(root, values);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < values.size(); i++) {
            minDiff = Math.min(minDiff, values.get(i) - values.get(i - 1));
        }
        return minDiff;
    }
    public static void inOrder(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}