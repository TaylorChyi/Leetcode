/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root != null) level(root, result, 1);
        return result;
    }

    public void level(TreeNode node, List<List<Integer>> result, int depth) {
        if (node == null) return;
        if (result.size() < depth) {
            result.add(0, new ArrayList<Integer>());
        }
        result.get(result.size()-depth).add(node.val);
        level(node.left, result, depth + 1);
        level(node.right, result, depth + 1);

    }
}
// @lc code=end

