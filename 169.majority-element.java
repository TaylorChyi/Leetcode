import java.util.Arrays;
import java.util.Map;

/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        // Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // for (int i : nums) {
        //     if (map.getOrDefault(i, 0) >= nums.length / 2) {
        //         return i;
        //     }
        //     else {
        //         map.put(i, map.getOrDefault(i, 0) + 1);
        //     }
        // }

        // return 0;


        // Arrays.sort(nums);
        // return nums[nums.length/2];

        int count=0, ret = 0;
        for (int num: nums) {
            if (count==0)
                ret = num;
            if (num!=ret)
                count--;
            else
                count++;
        }
        return ret;
        // 消消乐
    }
}
// @lc code=end

