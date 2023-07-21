/*
 * @lc app=leetcode id=589 lang=java
 *
 * [589] N-ary Tree Preorder Traversal
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

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> result = new ArrayList<Integer>();
    
    public List<Integer> preorder(Node root) {
        if (root != null) pre(root);

        return result;
    }

    public void pre(Node node) {
        if (node == null) return;

        result.add(node.val);
        for (Node n : node.children) {
            pre(n);
        }

    }
}
// @lc code=end

