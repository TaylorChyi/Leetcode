/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
 */

// @lc code=start

import java.util.List;
import java.util.Map;
import java.util.Set;

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
    // Map<Integer, Integer> modes = new HashMap<Integer, Integer>();

    // public int[] findMode(TreeNode root) {

    //     findModeHelper(root);

    //     return getModes(findMaxModeFrequence());
    // }

    // public void findModeHelper(TreeNode root) {
    //     if (root == null) return;
        
    //     modes.put(root.val, modes.getOrDefault(root.val, 0) + 1);

    //     findModeHelper(root.right);
    //     findModeHelper(root.left);
    // }

    // public int findMaxModeFrequence() {
    //     int max = 0;
    //     for (Map.Entry<Integer, Integer> entry : modes.entrySet()) {
    //         if (max < entry.getValue()) {
    //             max = entry.getValue();
    //         }
    //     }
    //     return max;
    // }

    // public int[] getModes(int maxModeFrequence){
    //     List<Integer> list = new ArrayList<Integer>();

    //     for (Map.Entry<Integer, Integer> entry : modes.entrySet()) {
    //         if (entry.getValue() == maxModeFrequence) {
    //             list.add(entry.getKey());
    //         }
    //     }
    //     int[] result = new int[list.size()];
    //     for (int i = 0; i < list.size(); i++) {
    //         result[i] = list.get(i);
    //     }
    //     return result;
    // }

    int maxFrequence = 0;
    int currentFrequence = 0;
    Set<Integer> modes = new HashSet<Integer>();
    Integer currentMode = null;

    public int[] findMode(TreeNode root) {
        if (root == null) {
                    return new int[0];
        }

        currentMode = root.val;
        findModeHelper(root);
        
        int[] result = new int[modes.size()];
        int index = 0;
        for (int mode : modes) {
            result[index++] = mode;
        }
        return result;
    }

    public void findModeHelper(TreeNode root) {
        if (root == null) return;

        findModeHelper(root.left);

        if (currentMode != root.val) {
            currentMode = root.val;
            currentFrequence = 0;
        }
        currentFrequence++;

        if (currentFrequence > maxFrequence) {
            maxFrequence = currentFrequence;
            modes.clear();
            modes.add(root.val);
        }

        else if (currentFrequence == maxFrequence) {
            modes.add(root.val);
        }

        findModeHelper(root.right);
    }
}
// @lc code=end

