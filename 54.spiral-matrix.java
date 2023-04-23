import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int direction = 0;
        // right - 0; down - 1; left - 2; up - 3;
        for (int i = 0, j = 0, k = 0; k < matrix[0].length * matrix.length; k++) {
            result.add(matrix[i][j]);
            matrix[i][j] = 200;
            
            if (direction == 0) {
                if (j == matrix[0].length - 1 || matrix[i][j+1] == 200) {
                    direction = 1;
                    i++;
                }
                else {
                    j++;
                }
            }
            else if (direction == 1) {
                if (i == matrix.length - 1 || matrix[i+1][j] == 200) {
                    direction = 2;
                    j--;
                }
                else {
                    i++;
                }
            }
            else if (direction == 2) {
                if (j == 0 || matrix[i][j-1] == 200) {
                    direction = 3;
                    i--;
                }
                else {
                    j--;
                }
            }
            else {
                if (i == 0 || matrix[i-1][j] == 200) {
                    direction = 0;
                    j++;
                }
                else {
                    i--;
                }
            }
        }

        return result;
    }
}
// @lc code=end

