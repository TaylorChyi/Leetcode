/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int x0 = num;
        int x1 = (x0 + num / x0) / 2;
        while (x0 > x1) {
            x0 = x1;
            x1 = (x0 + num / x0) / 2;
        }

        return x1 * x1 == num;
    }
}
// @lc code=end

