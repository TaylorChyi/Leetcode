/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start
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
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;

        level(root, result, 1);
        return result;
    }

    public void level(TreeNode node, List<List<Integer>> result, int depth) {
        if (node == null) return;
        if (result.size() < depth) {
            result.add(new ArrayList<Integer>());
        }
        result.get(depth-1).add(node.val);

        level(node.left, result, depth + 1);
        level(node.right, result, depth + 1);
    }
}
// @lc code=end

