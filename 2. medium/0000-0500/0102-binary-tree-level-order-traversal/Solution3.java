import java.util.*;
// LeetCode #0102: Binary Tree Level Order Traversal
// Approach: BFS With Level Size Trick
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
        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                TreeNode curr = q.remove();
                currLevel.add(curr.val);
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            result.add(currLevel);
        }
        return result;
    }
}