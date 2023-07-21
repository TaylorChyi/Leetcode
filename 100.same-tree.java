/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
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
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     Boolean[] result = new Boolean[]{true};
    //     isSameNode(result, p, q);
        
    //     return result[0];
    // }

    // public void isSameNode(Boolean[] flag, TreeNode p, TreeNode q) {
    //     if (p != null && q != null) {
    //         if (p.val == q.val){
    //             isSameNode(flag, p.right, q.right);
    //             isSameNode(flag, p.left, q.left);
    //         }
    //         else {
    //             flag[0] = false;
    //         }
    //     }
    //     else {
    //         if (!(p == null && q == null)) {
    //             flag[0] = false;
    //         }
    //     }
    // }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;
        if (q == null) return false;
        if (p == null) return false;
        if (q.val != p.val) return false;

        return isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
    } 
}
// @lc code=end

