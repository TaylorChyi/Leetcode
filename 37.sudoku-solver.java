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

        // for (int i = 0; i < 9; i++) {
        //     System.out.println(rows[i].size());
        //     System.out.println(columns[i].size());
        //     System.out.println(grids[i].size());
        // }
        
        
        backTrackSolveSudoku(0, 0, board, rows, columns, grids);
    }

    public boolean backTrackSolveSudoku(int i, int j, char[][] board, Set<Character>[] rows, Set<Character>[] columns, Set<Character>[] grids) {
        if (i == 9) { // If the end of the board is reached, the sudoku is solved
            return true;
        }

        if (board[i][j] != '.') { // If the cell is not empty, continue with the next cell
            return backTrackSolveSudoku(j == 8 ? (i + 1) : i, (j + 1) % 9, board, rows, columns, grids);
        }

        for (char k = '1'; k <= '9'; k++) { // Try placing '1' to '9' in the current cell
            if (rows[i].contains(k) &&
            columns[j].contains(k) &&
            grids[(i / 3) * 3 + j / 3].contains(k)) {
                board[i][j] = k;
                rows[i].remove(k); // Remove the character from the available set
                columns[j].remove(k); // Remove the character from the available set
                grids[(i / 3) * 3 + j / 3].remove(k); // Remove the character from the available set

                if (backTrackSolveSudoku(j == 8 ? (i + 1) : i, (j + 1) % 9, board, rows, columns, grids)) {
                    return true;
                }

                // Backtrack if placing k doesn't lead to a solution
                board[i][j] = '.';
                rows[i].add(k); // Add the character back to the available set
                columns[j].add(k); // Add the character back to the available set
                grids[(i / 3) * 3 + j / 3].add(k); // Add the character back to the available set
            }
        }

        return false; // Return false if no valid number can be placed in the current cell
    }


}
// @lc code=end

