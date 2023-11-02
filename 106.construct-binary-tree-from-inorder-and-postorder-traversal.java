/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 */

// @lc code=start

import java.util.HashMap;

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
    int[] postorderList;
    HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        initialize(inorder, postorder);
        return buildSubTree(postorder.length - 1, 0, inorder.length - 1);
    }

    public void initialize(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        postorderList = postorder;
    }

    public TreeNode buildSubTree(int postEnd, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorderList[postEnd]);

        int index = inorderIndexMap.get(root.val);

        root.right = buildSubTree(postEnd - 1, index + 1, inEnd);
        root.left = buildSubTree(postEnd - (inEnd - index) - 1, inStart, index - 1);

        return root;
    }
}
// @lc code=end

