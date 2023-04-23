import java.util.Set;

/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] list = s.toCharArray();
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            while (i < j && !vowels.contains(s.charAt(i))) {
                i++;
            }
            while (i < j && !vowels.contains(s.charAt(j))) {
                j--;
            }
            char temp = list[i];
            list[i] = list[j]; 
            list[j] = temp;
        }
        return String.valueOf(list);
    }
}
// @lc code=end

