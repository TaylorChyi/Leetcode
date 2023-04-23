/*
 * @lc app=leetcode id=551 lang=java
 *
 * [551] Student Attendance Record I
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        int consecutiveLate = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                consecutiveLate++;
                if (consecutiveLate == 3) {
                    return false;
                }
            } else if (c == 'A') {
                countA++;
                if (countA == 2) {
                    return false;
                }
                consecutiveLate = 0;
            } else {
                consecutiveLate = 0;
            }
        }

        return true;
    }
}
// @lc code=end

