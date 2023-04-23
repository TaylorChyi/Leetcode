import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=500 lang=java
 *
 * [500] Keyboard Row
 */

// @lc code=start
class Solution {
    public String[] findWords(String[] words) {
        Set<Character> firstRow = new HashSet<Character>(Arrays.asList('q','w','e','r','t','y','u','i','o','p','Q','W','E','R','T','Y','U','I','O','P'));
        Set<Character> secondRow = new HashSet<Character>(Arrays.asList('a','s','d','f','g','h','j','k','l','A','S','D','F','G','H','J','K','L'));
        Set<Character> thirdRow = new HashSet<Character>(Arrays.asList('z','x','c','v','b','n','m', 'Z','X','C','V','B','N','M'));

        List<String> result = new ArrayList<String>();
        for (String word: words) {
            char c = word.charAt(0);
            int type = firstRow.contains(c) ? 1 : (secondRow.contains(c) ? 2 : 3);
            int currenttype = type;
            for (int i = 1; i < word.length(); i++) {
                c = word.charAt(i);
                currenttype = firstRow.contains(c) ? 1 : (secondRow.contains(c) ? 2 : 3);
                if (currenttype != type) {
                    break;
                }
            }
            if (currenttype == type) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}
// @lc code=end

