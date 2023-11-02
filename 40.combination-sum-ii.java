/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
import java.util.*;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(candidates);

        combinationSum2Helper(0, candidates, target, new ArrayList<Integer>(), result);
        
        return result;
    }

    public void combinationSum2Helper(int start, int[] candidates, int target, List<Integer> selectedItems, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(selectedItems));
            return;
        }

        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            // 当我们把排序做好了之后，这个数组就变得有序了起来，是方便去重的；
            // 那这就意味着，当我们拿到一个数的时候，1，1，1，2，3，4，4，5，6，7
            // 简单来说，如果我们要从上述的数组中得到所有的和是9的组合
            // 不完全 但是 至少有这几个 ： 117，1116，27，36，144
            // 就从这里面看，我们是该如何判断这个1是要还是不要呢？这个的跳过的依据是什么？

            if (i > start && candidates[i-1] == candidates[i]) continue;

            selectedItems.add(candidates[i]);
            combinationSum2Helper(i + 1, candidates, target - candidates[i], selectedItems, result);

            // 现在脑子里只有一个词，跳过去
            // 我觉得这个思路是对的，但是怎么跳过去，如何跳过去，是需要丰富的；
            // if (selectedItems.size() > 1 && 
            //     selectedItems.get(selectedItems.size() - 1).equals(selectedItems.get(selectedItems.size() - 2))) {
            //     selectedItems.remove(selectedItems.size() - 1);
            //     while (candidates[i-1] == candidates[i]) {
            //         i++;
            //     }
            // }
            // else {
            //     selectedItems.remove(selectedItems.size() - 1);
            //     i++;
            // }

            selectedItems.remove(selectedItems.size() - 1);            
            
        }
    }
}
// @lc code=end

