/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
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
    List<TreeNode> result = new ArrayList<>();

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root != null && subRoot != null) {
            getNodes(root, subRoot);
            for (TreeNode node : result) {
                if (isSame(node, subRoot)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSame(TreeNode node, TreeNode subNode) {
        if (node == null && subNode == null) return true;
        if (node == null) return false;
        if (subNode == null) return false;
        
        return node.val == subNode.val && isSame(node.left, subNode.left) && isSame(node.right, subNode.right);
    }

    public void getNodes(TreeNode node, TreeNode subRoot) {
        if (node == null) return;
        if (node.val == subRoot.val)
            result.add(node);
        getNodes(node.left, subRoot);
        getNodes(node.right, subRoot);

    }
}
// @lc code=end

