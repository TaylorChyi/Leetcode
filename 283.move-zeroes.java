/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {

        int slow_cursor = 0;
        
        for (int fast_cursor = 0; fast_cursor < nums.length; fast_cursor++) {
        
            if (nums[fast_cursor] != 0) {
            
                nums[slow_cursor] = nums[fast_cursor];
                
                slow_cursor++;
            }
        }

        for (; slow_cursor < nums.length; slow_cursor++) {
            nums[slow_cursor] = 0;
        }
    }
}
// @lc code=end

