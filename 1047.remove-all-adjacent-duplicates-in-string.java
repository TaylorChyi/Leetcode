/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> deque = new LinkedList<Character>();

        for (Character c : s.toCharArray()) {
            if (c == deque.peekFirst()) {
                deque.remove();
            } else {
                deque.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : deque) {
            sb.insert(0, ch);
        }

        return sb.toString();
    }
}
// @lc code=end
