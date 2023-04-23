/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        // if (n <= 0)
        //     return false;

        // while (n % 2 == 0) {
        //     n = n / 2;
        // }
        // return n == 1;
        return n > 0 && (n & n - 1) == 0;
    }
}
// @lc code=end

