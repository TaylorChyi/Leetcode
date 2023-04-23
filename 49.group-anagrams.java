import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.catalog.CatalogManager;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map<Map<Character, Integer>, List<String>> containerMap = new HashMap<Map<Character, Integer>, List<String>>();
        
        // for (String str : strs) {
        //     char[] charList = str.toCharArray();
        //     Map<Character, Integer> map = new HashMap<Character, Integer>();
        //     for (char c : charList) {
        //         map.put(c, map.getOrDefault(c, 0) + 1);
        //     }
        //     List<String> temp = containerMap.getOrDefault(map, new ArrayList<String>());
        //     temp.add(str);
        //     containerMap.put(map, temp);
        // }

        // List<List<String>> result = new ArrayList<List<String>>();
        // for (Map<Character, Integer> key : containerMap.keySet()) {
        //     result.add(containerMap.get(key));
        // }
        // return result;

        Map<String, List<String>> catagory = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] wordmap = new char[26];

            for (int i = 0; i < str.length(); i++) {
                wordmap[str.charAt(i) - 'a']++;
            }

            List<String> temp = catagory.getOrDefault(String.valueOf(wordmap), new ArrayList<String>());
            temp.add(str);
            catagory.put(String.valueOf(wordmap), temp);
        }

        
        return new ArrayList<>(catagory.values());
    }
}
// @lc code=end

