import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.security.sasl.SaslServer;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int front = 0;
        int back = 0;
        
        int resultLength = Integer.MAX_VALUE;
        String result = "";

        Map<Character, Integer> tHashMap = new HashMap<>();
        for (char string : t.toCharArray()) {
            tHashMap.put(string, tHashMap.getOrDefault(string, 0) + 1);
        }
        int count = t.length();

        // while (front < s.length()) {
            
        //     if (count > 0 && back < s.length()) {
        //         if (tHashMap.containsKey(s.charAt(back))) {
        //             tHashMap.put(s.charAt(back), tHashMap.get(s.charAt(back)) - 1);
        //             if (tHashMap.get(s.charAt(back)) >= 0) {
        //                 count--;
        //             }
        //         }
        //         back++;
        //     }
        //     else {

        //         if (count == 0 && resultLength > (back - front)) {
        //             resultLength = back - front;
        //             result = s.substring(front, back);
        //         }
                
        //         if (tHashMap.containsKey(s.charAt(front))) {
        //             tHashMap.put(s.charAt(front), tHashMap.get(s.charAt(front)) + 1);
        //             if (tHashMap.get(s.charAt(front)) > 0) {
        //                 count++;
        //             }
        //         }
        //         front++;
        //     }
        // }

        while (back < s.length()) {
            if (tHashMap.containsKey(s.charAt(back))) {
                tHashMap.put(s.charAt(back), tHashMap.get(s.charAt(back)) - 1);
                if (tHashMap.get(s.charAt(back)) >= 0) {
                    count--;
                }
            }
            back++;
            while (count == 0) {
                if (count == 0 && resultLength > (back - front)) {
                    resultLength = back - front;
                    result = s.substring(front, back);
                }
                
                if (tHashMap.containsKey(s.charAt(front))) {
                    tHashMap.put(s.charAt(front), tHashMap.get(s.charAt(front)) + 1);
                    if (tHashMap.get(s.charAt(front)) > 0) {
                        count++;
                    }
                }
                front++;
            }
        }
        
        return result;
    }
}
// @lc code=end

