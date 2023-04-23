/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        // List<Integer> result = new ArrayList<Integer>();

        // long temp = 1;
        // for (long n = 0; n <= rowIndex; n++) {
        //     result.add((int)temp);
        //     temp = temp * (rowIndex - n) / (n + 1);
        // }

        // return result;

        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i<rowIndex+1;i++) {
            res.add(1);
            for(int j=i-1;j>0;j--) {
                res.set(j, res.get(j-1)+res.get(j));
            }
        }
        return res;
    }
}
// @lc code=end

