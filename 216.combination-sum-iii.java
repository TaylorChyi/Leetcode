/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (k < 2 || k > 9 || n < 1 || n > 45) return results;

        combinationSum3Helper(1, k, n, new ArrayList<Integer>(), results);
        
        return results;
    }

    public void combinationSum3Helper(int startIndex, int remainingLayer, int target, List<Integer> selectedItem, List<List<Integer>> results) {
        if (remainingLayer == 0) {
            if (target == 0) {
                results.add(new ArrayList<>(selectedItem));
            }
            return;
        }

        for (int i = startIndex; i <= 9 && i <= target; i++) {
            selectedItem.add(i);
            combinationSum3Helper(i + 1, remainingLayer - 1, target - i, selectedItem, results);
            selectedItem.remove(selectedItem.size() - 1);
        }
    }
}
// @lc code=end

