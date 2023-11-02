/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        combinationSumHelper(0, candidates, target, new ArrayList<Integer>(), result);

        return result;
    }

    public void combinationSumHelper(int start, int[] candidates, int target, List<Integer> selectedItems, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(selectedItems));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                continue;
            }
            selectedItems.add(candidates[i]);
            combinationSumHelper(i, candidates, target - candidates[i], selectedItems, result);
            selectedItems.remove(selectedItems.size() - 1);
        }
    }

    public void test(int start, int[] candidates, int target, List<Integer> selectedItems, List<List<Integer>> result) {
        for (int i = 0 ; i < 4; i++) {
            for (int j = i; j < 4; j++) {
                for (int k = j; k < 4; k++) {
                    if (target == candidates[i] + candidates[j] + candidates[k]) {
                        selectedItems.add(candidates[i]);
                        selectedItems.add(candidates[j]);
                        selectedItems.add(candidates[k]);     
                        
                        result.add(new ArrayList<>(selectedItems));
                        selectedItems.clear();
                    }
                }
            }
        }
    }
}
// @lc code=end

