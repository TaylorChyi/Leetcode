import java.lang.annotation.Target;

/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        // int right = nums.length -1;
        // int left = 0;
        // while(left <= right) {
        //     int middle = (right + left) / 2;
        //     if (nums[middle] == target) {
        //         return middle;
        //     }
        //     if (nums[middle] < target) {
        //         left = middle + 1;
        //     }
        //     else {
        //         right = middle -1;
        //     }
        // }
        // return -1;

        int max = nums.length - 1;
        int min = 0;
        int index = max;
        while (nums[index] != target) {
            if ( (max - min) <= 1) {
                return -1;
            }

            if (nums[index] < target) {
                min = index;
            }
            else {
                max = index;
            }

            index = min + (max - min) / 2;
        }

        return index;
    }
}
// @lc code=end

