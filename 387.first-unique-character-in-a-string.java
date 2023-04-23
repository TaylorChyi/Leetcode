/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] result = new int[26];
        int i = 1;
        for (char c : s.toCharArray()) {
            result[c-'a'] = result[c-'a'] == 0 ? i : -i;
            i++;
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < result.length; j++) {
            if (result[j] > 0) {
                min = min < result[j]-1 ? min : result[j]-1;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
        // int freq [] = new int[26];
        // for(int i = 0; i < s.length(); i ++)
        //     freq [s.charAt(i) - 'a'] ++;
        // for(int i = 0; i < s.length(); i ++)
        //     if(freq [s.charAt(i) - 'a'] == 1)
        //         return i;
        // return -1;
    }
}
// @lc code=end

