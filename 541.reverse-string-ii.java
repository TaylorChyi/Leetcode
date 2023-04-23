/*
 * @lc app=leetcode id=541 lang=java
 *
 * [541] Reverse String II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] sList = s.toCharArray();
        for (int i = 0; i < sList.length; i += 2 * k) {
            for (int j = i, z = i + k - 1 >= sList.length ? sList.length - 1 : i + k - 1 ; j < z; j++,  z--) {
                char temp = sList[j];
                sList[j] = sList[z];
                sList[z] = temp;
            }
        }
        return String.valueOf(sList);
    }
}
// @lc code=end

