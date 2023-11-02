/*
 * @lc app=leetcode id=326 lang=java
 *
 * [326] Power of Three
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n > 3) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }

        return n == 3 || n == 1;
    }
}
// @lc code=end

