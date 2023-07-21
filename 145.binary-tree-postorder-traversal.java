/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<Integer>();
    //     postorder(root, result);
    //     return result;
    // }

    // public void postorder(TreeNode node, List<Integer> result) {
    //     if (node == null)
    //         return;

    //     postorder(node.left, result);
    //     postorder(node.right, result);
    //     result.add(node.val);

    // }

    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) return result;

        stack.add(root);
        TreeNode node;

        while (!stack.isEmpty()) {
            node = stack.pop();
            result.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }

        Collections.reverse(result);
        return result;
    }
}
// @lc code=end
