/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        
        int cur_two = 0;
        int cur_three = 0;
        int cur_five = 0;

        int[] dummy = new int[n];
        dummy[0] = 1;

        int val_two = dummy[cur_two] * 2;
        int val_three = dummy[cur_three] * 3;
        int val_five = dummy[cur_five] * 5;

        int min;
        for(int i = 1; i < n; i++) {
            min = val_two < val_three && val_two < val_five ? val_two : (val_three < val_five ? val_three : val_five);
            dummy[i] = min;

            if (min == val_two) {
                cur_two++;
                val_two = dummy[cur_two] * 2;
            }
            if (min == val_three) {
                cur_three++;
                val_three = dummy[cur_three] * 3;
            }
            if (min == val_five) {
                cur_five++;
                val_five = dummy[cur_five] * 5;
            }
        }

        return dummy[n-1];
    }
}
// @lc code=end

