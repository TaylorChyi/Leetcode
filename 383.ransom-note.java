/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] charList = new int[26];
        for (char m : magazine.toCharArray()) {
            charList[m -'a']++;
        }
        for (char r : ransomNote.toCharArray()) {
            charList[r -'a']--;
            if (charList[r - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

