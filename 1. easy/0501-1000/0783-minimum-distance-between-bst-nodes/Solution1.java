import java.util.*;
// LeetCode #0783: Minimum Distance Between BST Nodes
// Approach: Brute Force
// Status: ✅ Accepted
// Time: O(n²)  |  Space: O(n)

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
        preOrder(root, values);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < values.size(); i++) {
            for(int j = i + 1; j < values.size(); j++) {
                minDiff = Math.min(minDiff, Math.abs(values.get(i) - values.get(j)));
            }
        }
        return minDiff;
    }
    public static void preOrder(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}