/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] board = new int[n];
        boolean[] cols = new boolean[n]; // 列是否被占用
        boolean[] diag1 = new boolean[2 * n]; // 正对角线
        boolean[] diag2 = new boolean[2 * n]; // 反对角线

        backTrackSolveNQueens(0, board, result, cols, diag1, diag2);
        return result;
    }

    private void backTrackSolveNQueens(int row, int[] board, List<List<String>> result, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            int d1 = row - col + board.length;
            int d2 = row + col;
            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            board[row] = col;
            cols[col] = diag1[d1] = diag2[d2] = true;

            backTrackSolveNQueens(row + 1, board, result, cols, diag1, diag2);

            board[row] = -1;
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }

    private List<String> construct(int[] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            char[] temp = new char[board.length];
            for (int j = 0; j < board.length; j++) {
                if (board[i] == j) {
                    temp[j] = 'Q';
                }
                else {
                    temp[j] = '.';
                }
            }
            res.add(String.valueOf(temp));
        }
        return res;
    }
}
// @lc code=end

