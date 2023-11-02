/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 */

// @lc code=start
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            int remainder = columnNumber % 26;
            if (remainder == 0) {
                columnNumber = columnNumber / 26 - 1;
                remainder = 26;
            }
            else {
                columnNumber = columnNumber / 26;
            }

            result.insert(0, (char)('A' + remainder - 1));
        }

        return result.toString();
    }
}
// @lc code=end

