/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public Node connect(Node root) {
        Deque<Node> queue = new LinkedList<Node>();

        if (root == null) return root;

        queue.offerLast(root);

        Node node, nextNode;
        while (!queue.isEmpty()) {
            queue.offerLast(null);

            while ( (node = queue.pollFirst()) != null ) {
                nextNode = queue.peekFirst();
                node.next = nextNode;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return root;
    }
}
// @lc code=end

