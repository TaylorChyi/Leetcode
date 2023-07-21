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

        // Map<Character, Character> s_t_CharacterMap = new HashMap<>();
        // Map<Character, Character> t_s_CharacterMap = new HashMap<>();
        
        char[] s_t_CharacterMap = new char[128];
        char[] t_s_CharacterMap = new char[128];

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
        
            // 如果 sChar 或 tChar 之前没有被映射，则将其映射到对应的字符
            // s_t_CharacterMap.putIfAbsent(sChar, tChar);
            // t_s_CharacterMap.putIfAbsent(tChar, sChar);


            // 如果 sChar 或 tChar 之前没有被映射，则将其映射到对应的字符
            if (s_t_CharacterMap[sChar] == 0) {
                s_t_CharacterMap[sChar] = tChar;
            }
            if (t_s_CharacterMap[tChar] == 0) {
                t_s_CharacterMap[tChar] = sChar;
            }

            // if (s_t_CharacterMap.get(sChar) != tChar ||
            //     t_s_CharacterMap.get(tChar) != sChar) {
            //     return false;
            // }
            if (s_t_CharacterMap[sChar] != tChar || t_s_CharacterMap[tChar] != sChar) {
                return false;
            }
        }
        return true;        

    }
}
// @lc code=end

/* 
 * 我们现在来分析这个代码的需求，我们可以写下来如下需求：
 * 1. 我先来建立每一个字符在第一个单词中对应到第二个单词的联系；
 * 2. 至于如何去判断是否不符合要求：两个字符不能指向同一个字符，自己可以指向自己
 */

