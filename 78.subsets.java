/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        results.add(new ArrayList<>());
        backTrackSubsets(0, nums, results.get(0), results);

        return results;
    }

    public void backTrackSubsets(int start, int[] nums,
                                 List<Integer> items, List<List<Integer>> results) {
        
        for (int i = start; i < nums.length; i++) {
            items.add(nums[i]);
            results.add(new ArrayList<>(items));
            backTrackSubsets(i + 1, nums, items, results);
            items.remove(items.size() - 1);
        }
    }
}
// @lc code=end

