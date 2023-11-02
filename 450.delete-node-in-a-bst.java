/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if (root.left == null && root.right == null) 
                return null;
            if (root.left == null) 
                return root.right;
            if (root.right == null)
                return root.left;
            
            root.val = findLeftSubtreeMaxNode(root.left);
            root.left = deleteNode(root.left, root.val);
        }

        return root;

    }

    public int findLeftSubtreeMaxNode(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }

        return node.val;
    }
}
// @lc code=end

