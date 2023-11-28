/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        
        int[] result = new int[1];
        
        backTrack(0, cols, diag1, diag2, result);

        return result[0];
    }
    public void backTrack(int layer, boolean[] cols, 
                            boolean[] diag1, boolean[] diag2, int[] result) {
        if (layer == cols.length) {
            result[0]++;
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (cols[col]) {
                continue;
            }
            else {
                int d1 = layer - col + cols.length - 1; 
                int d2 = layer + col;

                if (!diag1[d1] && !diag2[d2]) {
                    
                    cols[col] = diag1[d1] = diag2[d2] = true;

                    backTrack(layer + 1, cols, diag1, diag2, result);

                    cols[col] = diag1[d1] = diag2[d2] = false;
                }
            }
        }        
    }
}
// @lc code=end

