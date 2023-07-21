/*
 * @lc app=leetcode id=559 lang=java
 *
 * [559] Maximum Depth of N-ary Tree
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        return currentDepth(root, 1);
    }

    public int currentDepth(Node node, int depth) {
        if (node == null) {
            return depth;
        }

        int max = depth;
        for (Node child : node.children) {
            int currentDepth = currentDepth(child, depth+1);
            if (currentDepth > max) {
                max = currentDepth;
            }
        }   

        return max;
    }

    // public int maxDepth(Node root) {
    //     if (root == null) {
    //         return 0;
    //     }

    //     int max = 0;
    //     for (Node child : root.children) {
    //         max = Math.max(max, maxDepth(child));
    //     }

    //     return max + 1;
    // }
}
// @lc code=end

