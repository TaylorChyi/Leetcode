import java.util.HashMap;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int index = 0;
        while (index < nums.length) {
            if (map.containsKey(nums[index])) {
                return new int[] {map.get(nums[index]), index};
            }
            map.put(target - nums[index], index);
            index++;
        }
        return null;
    }
}
// @lc code=end

