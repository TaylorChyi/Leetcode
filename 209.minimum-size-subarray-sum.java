/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int frontBound = 0;
        int backBound = 0;
        int result = Integer.MAX_VALUE;
        int sum = nums[0];

        while (backBound < nums.length) {
            if (sum >= target) {
                if (backBound - frontBound + 1 <= result) {
                    result = backBound - frontBound + 1;
                    if (result == 1 || result == Integer.MAX_VALUE) {
                        return result; 
                    }
                }
                sum -= nums[frontBound++];
            }
            else {
                backBound++;
                if (backBound < nums.length) {
                    sum += nums[backBound];
                }
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
// @lc code=end

