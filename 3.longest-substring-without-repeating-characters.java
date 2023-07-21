/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        Set<Character> subString = new HashSet<Character>();
        int max = -1;
        for (int end = 0; end < s.length(); end++) {
            if (subString.contains(s.charAt(end))) {
                while(s.charAt(start) != s.charAt(end)) {
                    subString.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            else {
                subString.add(s.charAt(end));
                max = max < end - start ? end - start : max;
            }
        }
        return max + 1;
    }
}
// @lc code=end

