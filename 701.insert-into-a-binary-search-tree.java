/*
 * @lc app=leetcode id=701 lang=java
 *
 * [701] Insert into a Binary Search Tree
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        insertIntoBSTHelper(root, val);

        return root;
    }

    public void insertIntoBSTHelper(TreeNode node, int val) {
        if (node.val < val) 
            if (node.right == null)
                node.right = new TreeNode(val);
            else
                insertIntoBSTHelper(node.right, val);
        else
            if (node.left == null)
                node.left = new TreeNode(val);
            else
                insertIntoBSTHelper(node.left, val);
    }
}
// @lc code=end

