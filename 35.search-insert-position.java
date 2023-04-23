/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (42.13%)
 * Likes:    11113
 * Dislikes: 518
 * Total Accepted:    1.9M
 * Total Submissions: 4.5M
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int middle = 0;
        while(left <= right) {
            middle = left + (right - left) / 2;

            if (nums[middle] < target) {
                if ((middle + 1) < nums.length) {
                    if (nums[middle + 1] >= target) {
                        return middle + 1;
                    }
                    else {
                        left = middle + 1;
                    }
                }
                else {
                    return nums.length;
                }
            }
            else {
                right = middle - 1;
            }
        }

        return 0;
    }
}
// @lc code=end

