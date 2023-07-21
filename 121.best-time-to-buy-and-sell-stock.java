/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int high = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            }
            int temp = prices[i] - low;
            high = high < temp ? temp : high;
        }

        return high;
    }
}
// @lc code=end

