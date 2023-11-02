/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        
        backTrackSubsetsWithDup(0, nums, result.get(0), result);

        return result;
    }

    public void backTrackSubsetsWithDup(int startIndex, int[] nums, List<Integer> items, List<List<Integer>> results) {
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) continue;

            items.add(nums[i]);
            results.add(new ArrayList<>(items));
            backTrackSubsetsWithDup(i + 1, nums, items, results);
            items.remove(items.size() - 1);
        }
    }
}
// @lc code=end

