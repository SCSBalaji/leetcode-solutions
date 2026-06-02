import java.util.*;
// LeetCode #0102: Binary Tree Level Order Traversal
// Approach: Brute Force - BFS
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
        if(root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> currLevel = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode curr = q.remove();
            if(curr == null) {
                result.add(currLevel);
                currLevel = new ArrayList<>();
                if(!q.isEmpty()) {
                    q.add(null);
                }
                else {
                    break;
                }
            }
            else {
                currLevel.add(curr.val);
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return result;
    }
}