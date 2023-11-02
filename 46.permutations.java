/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        backTrackPermute(nums, new ArrayList<Integer>(), result);

        return result;
    }

    public void backTrackPermute(int[] nums, 
                                List<Integer> item, List<List<Integer>> result) {
        if (item.size() == nums.length) {
            result.add(new ArrayList<>(item));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 16) continue;

            item.add(nums[i]);
            nums[i] = 16;
            backTrackPermute(nums, item, result);
            
            nums[i] = item.remove(item.size() - 1);
        }
    }
}
// @lc code=end

