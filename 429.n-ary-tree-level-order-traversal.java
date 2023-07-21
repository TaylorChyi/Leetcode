/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
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


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root != null) level(root, result, 1);

        return result;
    }

    public void level(Node node, List<List<Integer>> result, int depth) {
        if (result.size() < depth) {
            result.add(new ArrayList<Integer>());
        }
        result.get(depth-1).add(node.val);

        for (Node n : node.children) {
            if ( n != null) level(n, result, depth+1);
        }
    }
}
// @lc code=end

