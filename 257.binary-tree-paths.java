/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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

    public List<String> binaryTreePaths(TreeNode node) {
        List<String> rootToLeaves = new ArrayList<String>();

        if (node != null) {
            rootToLeaves(node, String.valueOf(node.val), rootToLeaves);
        }

        return rootToLeaves;
    }

    public void rootToLeaves(TreeNode node, String path, List<String> rootToLeaves) {
        if (node.right == null && node.left == null) {
            rootToLeaves.add(path);
            return;
        }

        if (node.left != null) {
            rootToLeaves(node.left, path + "->" + node.left.val, rootToLeaves);
        }

        if (node.right != null) {
            rootToLeaves(node.right, path + "->" + node.right.val, rootToLeaves);
        
        }
    }
}
// @lc code=end
