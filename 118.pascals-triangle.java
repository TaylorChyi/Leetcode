import java.util.List;

/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        // if (numRows <= 0) {
        //     return new ArrayList<List<Integer>>();
        // }
        // List<List<Integer>> result = new ArrayList<List<Integer>>();
        // List<Integer> dummy = new ArrayList<Integer>();
        // dummy.add(1);
        // result.add(dummy);

        // for (int n = 1; n < numRows; n++) {
        //     dummy = new ArrayList<Integer>();
        //     dummy.add(1);
        //     int temp = 1;
        //     for (int k = 1; k <= n-1; k++) {
        //         temp *= (n - k + 1);
        //         temp /= k;
        //         dummy.add(temp);
        //     }
        //     dummy.add(1);
        //     result.add(dummy);
        // }

        // return result;

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                temp.add(1);
                for (int k = j-1; k > 0; k--) {
                    temp.set(k, temp.get(k) + temp.get(k-1));
                }
            }
            
            result.add(temp);
        }

        return result;
    }
}
// @lc code=end

