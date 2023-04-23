/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow_cursor = 0;
        for (int fast_cursor = 0; fast_cursor < nums.length; fast_cursor++) {
            if (nums[fast_cursor] != val) {
                nums[slow_cursor] = nums[fast_cursor];
                slow_cursor++;
            }
        }

        return slow_cursor;
    }
}
// @lc code=end

