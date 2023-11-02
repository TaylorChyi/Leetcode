/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
import java.util.*;;
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        combineHelper( n, k, new ArrayList<>(), result);
        
        return result;

    }

    public void combineHelper(int end, int restLayer, List<Integer> combination, List<List<Integer>> result) {
        if (restLayer == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = end; i >= restLayer; i--) {
            combination.add(i);
            combineHelper(i - 1, restLayer - 1, combination, result);
            combination.remove(combination.size() - 1);
        }
        
    }

}
// @lc code=end