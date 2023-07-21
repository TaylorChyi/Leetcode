/*
 * @lc app=leetcode id=590 lang=java
 *
 * [590] N-ary Tree Postorder Traversal
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
    List<Integer> result =  new ArrayList<Integer>();

    public List<Integer> postorder(Node root) {
        if (root != null) post(root);

        return result;
    }

    public void post(Node node) {
        if (node == null) return;

        for (Node n : node.children) {
            post(n);
        }

        result.add(node.val);
    }
}
// @lc code=end

