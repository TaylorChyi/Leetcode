/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int rightIndex = nums.length - 1;
        int leftIndex = 0;

        int rightHolder = nums[rightIndex] * nums[rightIndex];
        int leftHolder = nums[leftIndex] * nums[leftIndex];

        int[] result = new int[nums.length];
        int resultIndex = result.length - 1;

        while (resultIndex >= 0) {
            if (rightHolder > leftHolder) {
                result[resultIndex] = rightHolder;
                rightIndex--;
                if (rightIndex >= 0) {
                    rightHolder = nums[rightIndex] * nums[rightIndex];
                }
            }
            else {
                result[resultIndex] = leftHolder;
                leftIndex++;
                if (leftIndex < nums.length) {
                    leftHolder = nums[leftIndex] * nums[leftIndex];
                }
            }
            resultIndex--;
        }

        return result;
    }
}
// @lc code=end

