/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int x0 = 1;
        int x1 = 2;
        int temp;
        for (int i = 0; i < n-2; i++) {
            temp = x0 + x1;
            x0 = x1;
            x1 = temp;
        }
        return x1;
        
    }
}
// @lc code=end

