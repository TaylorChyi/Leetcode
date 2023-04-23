import java.util.Map;

/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> dummy = new HashMap<Character, Integer>();
        
        for (Character c : s.toCharArray()) {
            dummy.put(c, dummy.getOrDefault(c, 0) + 1);
        }
        for (Character c : t.toCharArray()) {
            if (dummy.containsKey(c)) {
                if (dummy.get(c) == 1) {
                    dummy.remove(c);
                }
                else {
                    dummy.put(c, dummy.get(c) - 1);
                }
            }
            else {
                return false;
            }
        }

        return dummy.isEmpty();
    }
}
// @lc code=end

