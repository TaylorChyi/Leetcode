import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> characterMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
        
            if (characterMap.containsKey(sChar) || characterMap.containsKey(tChar)) {
                if (characterMap.get(sChar) == null || characterMap.get(sChar) != tChar ||
                characterMap.get(tChar) == null || characterMap.get(tChar) != sChar) {
                    return false;
                }
            } else {
                characterMap.put(sChar, tChar);
                characterMap.put(tChar, sChar);
            }
        }
        return true;        

    }
}
// @lc code=end

