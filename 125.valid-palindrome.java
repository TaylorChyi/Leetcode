/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int length = 0;
        for (char c : s.toCharArray()) {
            if ( (c-'a' >= 0 && c-'a' <= 25) || c-'A' >= 0 && c-'A' <= 25 || c-'0' >= 0 && c-'0' <= 9 ) {
                length++;
            }
        }
        char[] result = new char[length];
        int i = 0;
        for (char c : s.toCharArray()) {
            if ( (c-'a' >= 0 && c-'a' <= 25) || c-'A' >= 0 && c-'A' <= 25 || c-'0' >= 0 && c-'0' <= 9 ) {
                result[i] = c;
                i++;
            }
        }

        for (int j = 0; j < length/2; j++) {
            if (result[j] -'0' >= 0 && result[j] -'0' <= 9 && result[j] - result[length-j-1] != 0) {
                return false;
            }
            if (result[j] - result[length-j-1] != 0 && result[j] - result[length-j-1] != 32 && result[j] - result[length-j-1] != -32)  {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

