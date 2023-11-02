/*
 * @lc app=leetcode id=654 lang=java
 *
 * [654] Maximum Binary Tree
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) 
            return null;

        TreeNode root = recursivelyContructMaximumBinaryTree(nums, 0, nums.length - 1);
    
        return root;
    }

    public TreeNode recursivelyContructMaximumBinaryTree(int[] inorder, int start, int end) { 
        if (start > end) {
            return null;
        }

        int maxIndex = findMaxIndex(inorder, start, end);
        TreeNode root = new TreeNode(inorder[maxIndex]);

        root.left = recursivelyContructMaximumBinaryTree(inorder, start, maxIndex - 1);
        root.right = recursivelyContructMaximumBinaryTree(inorder, maxIndex + 1, end);
        
        return root;
        
    }

    public int findMaxIndex(int[] inorder, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (inorder[i] > inorder[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
// @lc code=end

