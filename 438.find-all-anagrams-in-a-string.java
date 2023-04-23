import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return Collections.emptyList();

        int[] pMap = new int[26];
        for (char c : p.toCharArray()) {
            pMap[c - 'a']++;
        }        

        List<Integer> result = new ArrayList<Integer>();
        int slow = 0;
        for (int fast = 0; fast < s.length();) {
            if (pMap[ s.charAt(fast)-'a' ] > 0) {
                pMap[ s.charAt(fast)-'a' ]--;
                fast++;
            }
            else if ( s.charAt(fast) == s.charAt(slow) ) {
                fast++;
                slow++;
            }
            else {
                fast++;
                slow = fast;
            }

            if (fast - slow == p.length() - 1) {
                result.add(slow);
                fast++;
                while ( s.charAt(fast) == s.charAt(slow) ) {
                    slow++;
                    result.add(slow);
                    fast++;
                }
                slow = fast;
                for (char c : p.toCharArray()) {
                    pMap[c - 'a']++;
                } 
            }
        }

        return result;
    }
}
// @lc code=end

