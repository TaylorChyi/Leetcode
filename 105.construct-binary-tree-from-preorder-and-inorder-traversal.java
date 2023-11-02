/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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

    private int[] preorderList;
    private Map<Integer, Integer> inorderIndexMap = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length || preorder.length <= 0) {
            return new TreeNode();
        }

        initialize(preorder, inorder);

        TreeNode root = buildSubTree(0, 0, inorder.length - 1);

        return root;
    }

    public void initialize(int[] preorder, int[] inorder) {
        preorderList = preorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
    }

    public TreeNode buildSubTree(int preorderIndex, int inorderListStart, int inorderListEnd) {
        if (inorderListStart > inorderListEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorderList[preorderIndex]);

        int inorderListIndex = inorderIndexMap.get(root.val);

        int leftSubTreeNodeAmount = inorderListIndex - inorderListStart;

        root.left = buildSubTree(preorderIndex + 1, inorderListStart, inorderListIndex - 1);
        root.right = buildSubTree(preorderIndex + leftSubTreeNodeAmount + 1, inorderListIndex + 1, inorderListEnd);

        return root;
    }

}
// @lc code=end

