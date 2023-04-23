/*
 * @lc app=leetcode id=771 lang=java
 *
 * [771] Jewels and Stones
 */

// @lc code=start
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] array = new int[58];
        int count = 0;
        for (char c : jewels.toCharArray()) {
            array[c-'A']++;
        }
        for (char c : stones.toCharArray()) {
            if (array[c-'A'] > 0) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

