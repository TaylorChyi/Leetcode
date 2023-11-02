/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start

import java.util.*;

class Solution {
    
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();

        Map<String, List<String>> lettersMap = new HashMap<String, List<String>>();
        lettersMap.put("2", new ArrayList<String>(Arrays.asList("a", "b", "c")));
        lettersMap.put("3", new ArrayList<String>(Arrays.asList("d", "e", "f")));
        lettersMap.put("4", new ArrayList<String>(Arrays.asList("g", "h", "i")));
        lettersMap.put("5", new ArrayList<String>(Arrays.asList("j", "k", "l")));
        lettersMap.put("6", new ArrayList<String>(Arrays.asList("m", "n", "o")));
        lettersMap.put("7", new ArrayList<String>(Arrays.asList("p", "q", "r", "s")));
        lettersMap.put("8", new ArrayList<String>(Arrays.asList("t", "u", "v")));
        lettersMap.put("9", new ArrayList<String>(Arrays.asList("w", "x", "y", "z")));

        List<String> results = new ArrayList<String>();

        String[] digitsList = digits.split("");

        letterCombinationsHelper(0, digitsList, lettersMap, new StringBuilder(), results);
        
        return results;
    }

    public void letterCombinationsHelper(int start, String[] digitsList, Map<String, List<String>> lettersMap, StringBuilder selectedItem, List<String> result) {
        if (start == digitsList.length && start == selectedItem.length()) {
            result.add(selectedItem.toString());
            return;
        }

        for (int i = start; i < digitsList.length; i++) {
            List<String> letters = lettersMap.get(digitsList[i]);
            for (String s : letters) {
                selectedItem.append(s);
                letterCombinationsHelper(i + 1, digitsList, lettersMap, selectedItem, result);
                selectedItem.deleteCharAt(selectedItem.length() - 1);
            }
        }
    }
}
// @lc code=end

