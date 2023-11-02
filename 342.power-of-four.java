/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int n) {
        while (n > 4) {
            if (n % 4 != 0) {
                return false;
            }
            n /= 4;
        }

        return n == 4 || n == 1;
    }
}
// @lc code=end

