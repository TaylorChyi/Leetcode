/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
import java.util.*;
class Solution {
    public void solveSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] grids = new HashSet[9];

        Set<Character> standerdSet = new HashSet<>();

        for (char item = '1'; item <= '9'; item++) {
            standerdSet.add(item);
        }

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>(standerdSet);
            columns[i] = new HashSet<>(standerdSet);
            grids[i] = new HashSet<>(standerdSet);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rows[i].remove(board[i][j]);
                    columns[j].remove(board[i][j]);
                    grids[i / 3 * 3 + j / 3].remove(board[i][j]);
                }
            }
        }
        
        backTrackSolveSudoku(0, 0, board, rows, columns, grids);
    }

    public boolean backTrackSolveSudoku(int i, int j, char[][] board, Set<Character>[] rows, Set<Character>[] columns, Set<Character>[] grids) {

        for (; i < 9; i++) {
            for (; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(i, j, k, rows, columns, grids)) {
                            board[i][j] = k;
                            if (backTrackSolveSudoku(i, j, board, rows, columns, grids)) 
                                return true;
                            else
                                board[i][j] = '.';
                        }            
                    }
                    return false;
                }
            }
            j = 0;
        }

        return true;
    }
    
    public boolean isValid(int row, int col, char c, Set<Character>[] rows, Set<Character>[] columns, Set<Character>[] grids) {

        if (rows[row].contains(c) && 
            columns[col].contains(c) && 
            grids[(row / 3) * 3 + col / 3].contains(c)) {

            rows[row].remove(c);
            columns[col].remove(c);
            grids[row / 3 * 3 + col / 3].remove(c);
            return true;
        }
        else {
            return false;
        }
    }
}
// @lc code=end

