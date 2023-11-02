/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Non-decreasing Subsequences
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        backTrackFindSubsequences(0, nums, new ArrayList<>(), results);

        return results;
    }

    public void backTrackFindSubsequences(int startIndex, int[] nums,
                                    List<Integer> items, List<List<Integer>> results) {
        if (items.size() > 1) {
            results.add(new ArrayList<>(items));
        }

        HashSet<Integer> usedStart = new HashSet<Integer>();

        for (int i = startIndex; i < nums.length; i++) {

            if (usedStart.contains(nums[i])) continue;

            if (items.isEmpty() || items.get(items.size() - 1) <= nums[i]) {
                items.add(nums[i]);
                usedStart.add(nums[i]);
                backTrackFindSubsequences(i + 1, nums, items, results);

                items.remove(items.size() - 1);
            }
        }
    }
}
// @lc code=end

