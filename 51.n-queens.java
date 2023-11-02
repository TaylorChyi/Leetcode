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
        char[][] board = new char[n][n];
        boolean[] cols = new boolean[n]; // 列是否被占用
        boolean[] diag1 = new boolean[2 * n]; // 正对角线
        boolean[] diag2 = new boolean[2 * n]; // 反对角线

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backTrackSolveNQueens(0, board, result, cols, diag1, diag2);
        return result;
    }

    private void backTrackSolveNQueens(int row, char[][] board, List<List<String>> result, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            int d1 = row - col + board.length;
            int d2 = row + col;
            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            board[row][col] = 'Q';
            cols[col] = diag1[d1] = diag2[d2] = true;

            backTrackSolveNQueens(row + 1, board, result, cols, diag1, diag2);

            board[row][col] = '.';
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(String.valueOf(row));
        }
        return res;
    }
}

// import java.util.*;
// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> result = new ArrayList<List<String>>();
//         char[][] board = new char[n][n];

//         for (char[] row : board) 
//             Arrays.fill(row, '.');

//         backTrackSolveNQueens(n - 1, board, result);

//         return result;
//     }

//     public List<String> construct(char[][] board) {
//         List<String> res = new ArrayList<>();
//         for (char[] row : board) {
//             res.add(String.valueOf(row));
//         }
//         return res;
//     }

//     public void backTrackSolveNQueens(int chessPieceIndex, char[][] board, List<List<String>> result) {
//         if (chessPieceIndex < 0) {
//             result.add(construct(board));
//             return;
//         }

//         for (int j = 0; j < board.length; j++) {
//             if (isValid(chessPieceIndex, j, board)) {
//                 board[chessPieceIndex][j] = 'Q';
//                 backTrackSolveNQueens(chessPieceIndex - 1, board, result);
//                 board[chessPieceIndex][j] = '.';
//             }
//         }
//     }

//     public boolean isValid(int i, int j, char[][] board) {
//         for (int k = i; k < board.length; k++) {
//             if (board[k][j] == 'Q') return false;
//         }

//         int m = i + 1;
//         int n = j + 1;
//         while (m >= 0 && m < board.length && n >= 0 && n < board.length) {
//             if (board[m][n] == 'Q') return false;
//             m++;
//             n++;
//         }

//         m = i + 1;
//         n = j - 1;
//         while (m >= 0 && m < board.length && n >= 0 && n < board.length) {
//             if (board[m][n] == 'Q') return false;
//             m++;
//             n--;
//         }

//         return true;
//     }
// }
// @lc code=end

