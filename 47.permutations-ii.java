/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        backTrackPermuteUnique(nums, new ArrayList<>(), result);

        return result;
    }

    public void backTrackPermuteUnique(int[] nums, List<Integer> items, List<List<Integer>> result) {
        if (items.size() == nums.length) {
            result.add(new ArrayList<>(items));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 16 || (i > 0 && nums[i] == nums[i-1])) continue;

            items.add(nums[i]);
            nums[i] = 16;

            backTrackPermuteUnique(nums, items, result);
            nums[i] = items.remove(items.size() - 1);
        }
    }
}
// @lc code=end

