/*
 * @lc app=leetcode id=520 lang=java
 *
 * [520] Detect Capital
 */

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() <=0 ) return false;

        if (word.length() == 1) return true;

        char c = word.charAt(0);
        if (c - 'A' >= 0 && c - 'A' <= 25) {
            int cNext;
            for (int i = 1; i < word.length() - 1; i++) {
                c = word.charAt(i);
                cNext = word.charAt(i+1);
                if (!((c - 'a' >= 0 && c - 'a' <= 25 && cNext - 'a' >= 0 && cNext - 'a' <= 25) ||
                (c - 'A' >= 0 && c - 'A' <= 25 && cNext - 'A' >= 0 && cNext - 'A' <= 25))) {
                    return false;
                }
            }
        }
        else {
            for (int i = 1; i < word.length(); i++) {
                c = word.charAt(i);
                if (!( c - 'a' >= 0 && c - 'a' <= 25)) {
                    return false;
                }
            }
        }

        return true;
    }
}
// @lc code=end
