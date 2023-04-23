/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuffer trimedString = removeRedundantSpace(s);

        reverseString(trimedString, 0, trimedString.length() - 1);

        reverseWord(trimedString);

        return trimedString.toString();
    }

    public StringBuffer removeRedundantSpace(String s) {
        int i = 0;
        int length = s.length() - 1;
        while (s.charAt(i) == ' ')
            i++;
        while (s.charAt(length) == ' ')
            length--;

        StringBuffer sb = new StringBuffer();

        while (i <= length) {
            if (s.charAt(i) != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(s.charAt(i));
            }
            i++;
        }

        return sb;
    }

    public void reverseString(StringBuffer sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public void reverseWord(StringBuffer sb) {
        int start = 0;
        int end = 1;
        while (start < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ')
                end++;

            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
// @lc code=end
