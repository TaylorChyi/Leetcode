/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode node) {
        if (node == null)
            return 0;

        int leftDepth = leftDepth(node);

        if (leftDepth == 0) return 1;

        if (rightDepth(node) == leftDepth)
            return (2 << leftDepth) - 1;
        else
            return countNodes(node.right) + countNodes(node.left) + 1;
    }

    private int leftDepth(TreeNode node) {
        int d = -1;
        while (node != null) {
            d++;
            node = node.left;
        }
        return d;
    }

    private int rightDepth(TreeNode node) {
        int d = -1;
        while (node != null) {
            d++;
            node = node.right;
        }
        return d;
    }
}

 // @lc code=end
