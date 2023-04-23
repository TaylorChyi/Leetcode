/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int direction = 1; // up - 4 , down - 2, left - 3, right - 1
        int i = 0;
        int j = 0;
        for (int k = 1; k <= n * n; k++) {
            matrix[i][j] = k;

            if (direction == 1) {
                if (j == n - 1 || matrix[i][j+1] > 0) {
                    direction = 2;
                    i++;
                }
                else {
                    j++;
                }
            }
            else if (direction == 2) {
                if (i == n - 1 || matrix[i+1][j] > 0) {
                    direction = 3;
                    j--;
                }
                else {
                    i++;
                }
            }
            else if (direction == 3) {
                if (j == 0 || matrix[i][j-1] > 0) {
                    direction = 4;
                    i--;
                }
                else {
                    j--;
                }
            }
            else {
                if (i == 0 || matrix[i-1][j] > 0) {
                    direction = 1;
                    j++;
                }
                else {
                    i--;
                }
            }
        }

        return matrix;
    }
}
// @lc code=end

