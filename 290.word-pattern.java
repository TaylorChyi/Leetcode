/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start

import java.util.Map;

class Solution {
    // public boolean wordPattern(String pattern, String s) {
    //     Map<String, String>KeyToWordMap = new HashMap<>();
    //     Map<String, String>WordToKeyMap = new HashMap<>();

    //     String[] words = s.split(" ");
    //     String[] keys = pattern.split("");

    //     if (words.length != keys.length) {
    //         return false;
    //     }

    //     for (int i = 0; i < words.length; i++) {
    //         String word = words[i];
    //         String key = keys[i];

    //         if (KeyToWordMap.containsKey(key) && WordToKeyMap.containsKey(word)) {
    //             if (KeyToWordMap.get(key).equals(word) && WordToKeyMap.get(word).equals(key)) {
    //                 continue;
    //             }
    //             return false;
    //         }
    //         else if (!KeyToWordMap.containsKey(key) && !WordToKeyMap.containsKey(word)) {
    //             KeyToWordMap.put(key, word);
    //             WordToKeyMap.put(word, key);
    //         }
    //         else {
    //             return false;
    //         }
            
    //     }

    //     return true;
    // }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> keyToWordMap = new HashMap<>();
        Map<String, Character> wordToKeyMap = new HashMap<>();

        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            char key = pattern.charAt(i);
            String word = words[i];

            // Check if key is already mapped to a word
            if (keyToWordMap.containsKey(key)) {
                if (!keyToWordMap.get(key).equals(word)) {
                    return false;
                }
            } else {
                keyToWordMap.put(key, word);
            }

            // Check if word is already mapped to a key
            if (wordToKeyMap.containsKey(word)) {
                if (!wordToKeyMap.get(word).equals(key)) {
                    return false;
                }
            } else {
                wordToKeyMap.put(word, key);
            }
        }
        return true;
    }

}
// @lc code=end

