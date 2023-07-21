/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] next = generateNext(s);
        return next[next.length-1] != 0 &&  next.length % (next.length - next[next.length - 1]) == 0;
    }

    public int[] generateNext(String str) {
        int[] next = new int[str.length()];
        int i = 0;
        next[0] = 0;
        for (int j = 1; j < str.length(); j++) {
            while (i > 0 && str.charAt(i)  != str.charAt(j)) {
                i = next[i-1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                i++;
            }

            next[j] = i;
        }

        return next;
    }
}
// @lc code=end

