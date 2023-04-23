/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder S = new StringBuilder("");
        StringBuilder T = new StringBuilder("");

        int slowCursorForS = 0;
        int slowCursorForT = 0;

        for (int fastCursorForS = 0; fastCursorForS < s.length(); fastCursorForS++) {
            if (s.charAt(fastCursorForS) == '#') {
                if (slowCursorForS > 0) {
                    slowCursorForS--;
                    S.deleteCharAt(slowCursorForS);
                }   
            }
            else {
                S.append(s.charAt(fastCursorForS));
                slowCursorForS++;
            }
    
        }
        for (int fastCursorForT = 0; fastCursorForT < t.length(); fastCursorForT++) {
            if (t.charAt(fastCursorForT) == '#') {
                if (slowCursorForT > 0) {
                    slowCursorForT--;
                    T.deleteCharAt(slowCursorForT);
                }      
            }
            else {
                T.append(t.charAt(fastCursorForT));
                slowCursorForT++;
            }
        }

        return S.toString().equals(T.toString());
    }
}
// @lc code=end

