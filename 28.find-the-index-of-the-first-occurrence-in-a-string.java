/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Find the Index of the First Occurrence in a String
 */

// @lc code=start
class Solution {
   
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int[] next = new int[needle.length()];
        getNext(next, needle);
        int h = 0;
        int n = 0;
        while (h < haystack.length()) {
            while (n > 0 && haystack.charAt(h) != needle.charAt(n)) {
                n = next[n-1];
            }

            if (haystack.charAt(h) == needle.charAt(n)) {
                n++;
            }

            h++;

            if (n == needle.length()) {
                return h - n;
            }
        }

        return -1;
    }

    public static void getNext(int[] next, String needle) {
        // int index = 0;
        // int[] next = new int[needle.length()];
        // next[0] = 0;
        // for (int j = 1; j < needle.length(); j++) {
        //     if (needle.charAt(index) == needle.charAt(j)) {
        //         index++;
        //         next[j] = index;
        //     }
        //     else {
        //         if (index == 0) {
        //             next[j] = 0;
        //         }
        //         else {
        //             index = next[index - 1];
        //             j--;
        //         }
        //     }
            
        // }
        // return next;

        int j = 0;
        next[0] = 0;
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) 
                j = next[j - 1];
            if (needle.charAt(j) == needle.charAt(i)) 
                j++;
            next[i] = j; 
        }
    }
}
// @lc code=end

