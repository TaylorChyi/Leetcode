import javax.naming.directory.SearchResult;
import javax.xml.stream.EventFilter;

/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {

    public int[] searchRange(int[] nums, int target) {
        int length = nums.length - 1;
        int left = 0;
        int right = length;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] < target) {
                left = middle + 1;
            }
            else if (nums[middle] > target) {
                right = middle - 1;
            }
            else {
                int left_2 = middle;
                int right_2 = right;
                int middle_2 = left_2 + (right_2 - left_2) / 2;
                int rightBorder = middle;

                int left_3 = left;
                int right_3 = middle;
                int middle_3 = left_3 + (right_3 - left_3) / 2;
                int leftBorder = middle;

                while (left_2 <= right_2) {

                    if (nums[middle_2] > target) {
                        right_2 = middle_2 - 1;
                    }
                    else {
                        left_2 = middle_2 + 1;
                        rightBorder = middle_2;
                    }

                    middle_2 = left_2 + (right_2 - left_2) / 2;
                }

                while (left_3 <= right_3) {
                    
                    if (nums[middle_3] < target) {
                        left_3 = middle_3 + 1;
                    }
                    else {
                        right_3 = middle_3 - 1;
                        leftBorder = middle_3;
                    }

                    middle_3 = left_3 + (right_3 - left_3) / 2;
                }

                return new int[]{leftBorder, rightBorder};
                

            }
        }

        return new int[]{-1, -1};
    }
}
// @lc code=end

