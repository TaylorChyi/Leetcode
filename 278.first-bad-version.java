/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int goodCensor = -1;

        while (left <= right) {
            goodCensor = left + (right - left) / 2;

            if (isBadVersion(goodCensor)) {    
                right = goodCensor - 1;
            }
            else {
                left = goodCensor + 1;
            }
        }

        return left;
    }
}
// @lc code=end

