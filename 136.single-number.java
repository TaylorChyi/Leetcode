import java.util.HashSet;

/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // HashSet<Integer> set = new HashSet<>();
        // for (int i = 0; i < nums.length; i++) {
        //     if (set.contains(nums[i])) {
        //         set.remove(nums[i]);
        //     }
        //     else  {
        //         set.add(nums[i]);
        //     }
        // }

        // return set.iterator().next();
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }

        return result;
    }
}
// @lc code=end

