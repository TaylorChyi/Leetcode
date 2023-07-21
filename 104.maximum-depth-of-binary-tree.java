/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
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
    public int maxDepth(TreeNode root) {
        return getMax(root, 1);
    }

    public int getMax(TreeNode node, int depth) {
        if (node == null) return depth-1;

        int right = getMax(node.right, depth + 1);
        int left = getMax(node.left, depth + 1);
        return right > left ? right : left;
    }
}
// @lc code=end

