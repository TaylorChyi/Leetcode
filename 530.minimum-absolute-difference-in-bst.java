/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
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

    TreeNode pre;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        recursivelyInorderTraverseBST(root);

        return min;
    }

    public void recursivelyInorderTraverseBST(TreeNode root) {
        if (root == null) return;

        recursivelyInorderTraverseBST(root.left);

        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }

        pre = root;

        recursivelyInorderTraverseBST(root.right);
    }
}
// @lc code=end

