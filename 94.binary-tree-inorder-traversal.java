import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> inorder_traversal_result = new ArrayList<Integer>();
    //     inorder(inorder_traversal_result, root);

    //     return inorder_traversal_result;
    // }

    // public void inorder(List<Integer> inorder_traversal_result, TreeNode node) {
    //     if (node != null) {
    //         inorder(inorder_traversal_result, node.left);
    //         inorder_traversal_result.add(node.val);
    //         inorder(inorder_traversal_result, node.right);
    //     }
    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();

        TreeNode cursor = root;

        while (cursor != null || !stack.isEmpty()) {
            if (cursor != null) {
                stack.push(cursor);
                cursor = cursor.left;
            }
            else {
                cursor = stack.pop();
                result.add(cursor.val);
                cursor = cursor.right;
            }
        }

        return result;
    }
}
// @lc code=end

