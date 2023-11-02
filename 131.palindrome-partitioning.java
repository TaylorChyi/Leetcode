/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();

        // for (int windowLength = 1; windowLength <= s.length(); windowLength++) {
        //     List<String> selectedItems = new ArrayList<String>();
        //     for (int i = 0; i + windowLength - 1 < s.length(); i++) {
        //         if (isPalindrome(s.substring(i, i + windowLength))) {
        //             selectedItems.add(s.substring(i, i + windowLength));
        //         }
        //         if (isPalindrome(s.substring(i + windowLength, s.length()))) {
        //             selectedItems.add(s.substring(i + windowLength, s.length()));
        //         }
        //         if (isPalindrome(s.substring(0, i))) {
        //             selectedItems.add(s.substring(0, i));
        //         }
        //     }

        //     result.add(new ArrayList<>(selectedItems));        
        // }

        partitionHelper(0, s, new ArrayList<>(), result);

        return result;
    }

    public void partitionHelper(int startIndex, String s, List<String> items, List<List<String>> result) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(items));
            return;
        }

        for (int i = startIndex + 1; i <= s.length(); i++) {
            String subString = s.substring(startIndex, i);
            if (isPalindrome(subString)) {
                items.add(subString);
                partitionHelper(i, s, items, result);
                items.remove(items.size() - 1);
            }
        }
    }

    // private
    public boolean isPalindrome(String s) {
        for (int i = 0; i <= s.length() / 2 - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

