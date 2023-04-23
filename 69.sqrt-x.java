/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int log = 1;
        for (int i = 0; i < 30; i++) {
            if (log > x) {
                log = log / 2;
                break;
            }
            log = log * 2;
        }

        int x0 = log;
        int x1 = log / 2;
        while (x1 < x0) {
            x0 = x1;
            x1 = (x0 + x / x0) / 2;
        }

        return x0;
    }
}
// @lc code=end

