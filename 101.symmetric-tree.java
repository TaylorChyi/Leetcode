/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirrored(root.left, root.right);
    }

    public boolean isMirrored(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) return true;
        if (leftTree == null || rightTree == null) return false;

        return leftTree.val == rightTree.val && 
            isMirrored(leftTree.left, rightTree.right) && 
            isMirrored(leftTree.right, rightTree.left);
    }
}
// @lc code=end

