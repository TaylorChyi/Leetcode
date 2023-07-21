/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 */

// @lc code=start

import java.util.Deque;
import java.util.List;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> queue = new LinkedList<>();

        if (root == null) return result;

        queue.offerLast(root);
        queue.offerLast(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            result.add(node.val);
            while (node != null) {
                if (node.right != null) queue.offerLast(node.right);
                if (node.left != null) queue.offerLast(node.left);
                node = queue.pollFirst();
            }
            // 这里需要注意如果不加这个判定条件，会让队列在之后充满了null。
            if (!queue.isEmpty()) {
                queue.offerLast(null);
            }
        }

        return result;
    }
}
// @lc code=end

