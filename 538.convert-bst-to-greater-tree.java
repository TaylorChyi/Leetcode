/*
 * @lc app=leetcode id=538 lang=java
 *
 * [538] Convert BST to Greater Tree
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

    public TreeNode convertBST(TreeNode root) {
        convertBSTHelper(root, 0);
        
        return root;
    }

    public int convertBSTHelper(TreeNode node, int sum) {
        if (node == null) return sum;
        
        node.val += convertBSTHelper(node.right, sum);

        return convertBSTHelper(node.left, node.val);
        
    }
}
// @lc code=end

