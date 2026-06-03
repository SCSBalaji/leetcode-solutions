import java.util.*;
// LeetCode #0783: Minimum Distance Between Bst Nodes
// Approach: Iterative Inorder With Stack
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
    public int minDiffInBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int prev = -1;
        int minDiff = Integer.MAX_VALUE;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(prev != -1) {
                minDiff = Math.min(minDiff, curr.val - prev);
            }
            prev = curr.val;
            curr = curr.right;
        }
        return minDiff;
    }
}