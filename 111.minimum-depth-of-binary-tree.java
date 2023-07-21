/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return getMin(root, 1);
    }

    public int getMin(TreeNode node, int depth) {
        if (node == null)
            return Integer.MAX_VALUE;

        if (node.left == null && node.right == null)
            return depth;

        int left = getMin(node.left, depth + 1);
        int right = getMin(node.right, depth + 1);

        return left < right ? left : right;
    }
}
// @lc code=end
