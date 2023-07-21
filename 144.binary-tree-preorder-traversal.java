/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<Integer>();
    //     preorder(root, result);
    //     return result;
    // }

    // public void preorder(TreeNode node, List<Integer> preorderList) {
    //     if (node == null) return;

    //     preorderList.add(node.val);
    //     preorder(node.left, preorderList);
    //     preorder(node.right, preorderList);

    // }

    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> dummy = new ArrayDeque<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) return result;
        
        dummy.push(root);
        while (dummy.size() > 0) {
            TreeNode node = dummy.pop();
            result.add(node.val);
            if (node.right != null) {
                dummy.push(node.right);
            }
            if (node.left != null) {
                dummy.push(node.left);
            }
        }

        return result;
    }
}
// @lc code=end

