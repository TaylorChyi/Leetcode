/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;
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
    public List<Integer> largestValues(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
            return result;

        queue.offerLast(root);

        while (!queue.isEmpty()) {
            queue.offerLast(null);

            TreeNode node;
            int max = Integer.MIN_VALUE;
            while ((node = queue.pollFirst()) != null) {
                if (node.left != null)
                    queue.offerLast(node.left);
                if (node.right != null)
                    queue.offerLast(node.right);

                max = max < node.val ? node.val : max;
            }
            result.add(max);
        }

        return result;
    }
}
// @lc code=end
