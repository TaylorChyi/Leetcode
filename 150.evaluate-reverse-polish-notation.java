/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> result = new ArrayDeque<Integer>();
        int i, j;
        for (String t : tokens) {
            switch (t) {
                case "*":
                    i = result.pop();
                    j = result.pop();
                    result.push(j * i);
                    break;
                case "/":
                    i = result.pop();
                    j = result.pop();
                    result.push(j / i);
                    break;
                case "+":
                    i = result.pop();
                    j = result.pop();
                    result.push(j + i);
                    break;
                case "-":
                    i = result.pop();
                    j = result.pop();
                    result.push(j - i);
                    break;
                default:
                    result.push(Integer.parseInt(t));
            }
        }

        return result.pop();
    }
}
// @lc code=end
