/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new LinkedList<Character>();

        for (char c : s.toCharArray()) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.size() == 0 || c != stack.peek()) {
                return false;
            } else {
                stack.pop();
            }
        }

        return stack.size() == 0;
    }
}
// @lc code=end
