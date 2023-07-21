/*
 * @lc app=leetcode id=482 lang=java
 *
 * [482] License Key Formatting
 */

// @lc code=start
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int count = k;
        for (int index = s.length() - 1; index >= 0; index--) {
            if (s.charAt(index) != '-') {
                if (count == 0) {
                    sb.append("-");
                    count = k;
                }
                sb.append(s.charAt(index));
                count--;
            }
        }

        return sb.reverse().toString().toUpperCase();
    }
}
// @lc code=end

