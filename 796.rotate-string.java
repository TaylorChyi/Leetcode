/*
 * @lc app=leetcode id=796 lang=java
 *
 * [796] Rotate String
 */

// @lc code=start
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        int cursorS = 0;
        
        for (int i = 0; i < goal.length(); i++) {
            if (goal.charAt(i) == s.charAt(cursorS)) {
                int cursorG = i;
                for (int j = 0; j < goal.length() - 1; j++) {
                    cursorG = ( cursorG + 1 ) % goal.length();
                    cursorS++;
                    if (goal.charAt(cursorG) != s.charAt(cursorS)) {
                        cursorS = 0;
                        break;
                    }
                }
                if (cursorS == goal.length()-1) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

