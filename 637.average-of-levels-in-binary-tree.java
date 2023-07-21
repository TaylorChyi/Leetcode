/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
 */

// @lc code=start

import java.util.Deque;
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        Deque<TreeNode> queue = new LinkedList<>();

        if (root == null) return result;

        queue.offerLast(root);
        queue.offerLast(null);
        while(!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();

            double sum = 0;
            double count = 0;
            while(node != null) {
                if (node.left != null) queue.offerLast(node.left);
                if (node.right != null) queue.offerLast(node.right);
                sum += node.val;
                count++;
                node = queue.pollFirst();
            }
            result.add(sum/count);

            if (!queue.isEmpty()) {
                queue.offerLast(null);
            }
        }

        return result;
    }
}
// @lc code=end

