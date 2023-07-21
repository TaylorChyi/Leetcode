/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        String longer = num1.length() - num2.length() > 0 ? num1 : num2;
        String shorter = num1.length() - num2.length() > 0 ? num2 : num1;

        for (int i = 0; i < shorter.length(); i++) {
            int j = (shorter.charAt(shorter.length() - i - 1) - '0') + (longer.charAt(longer.length() - i - 1) - '0')
                    + carry;
            carry = j / 10;
            sb.append((j % 10) + "");
        }
        for (int i = longer.length() - shorter.length() - 1; i >= 0; i--) {
            int j = longer.charAt(i) - '0' + carry;
            carry = j / 10;
            sb.append((j % 10) + "");
        }
        if (carry == 1) {
            sb.append(carry + "");
        }
        return sb.reverse().toString();
    }
}
// @lc code=end
