/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */
// @lc code=start
import java.util.*;
class Solution {
    // Class to represent a cell with its row, column and the possible candidates.
    private class Cell {
        int row, col, candidates;

        Cell(int row, int col, int candidates) {
            this.row = row;
            this.col = col;
            this.candidates = candidates;
        }
    }

    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] grids = new boolean[9][9];
        List<Cell> emptyCells = new ArrayList<>();

        // Initialize with the existing numbers.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    emptyCells.add(new Cell(i, j, 0));
                } else {
                    int num = board[i][j] - '1';
                    rows[i][num] = true;
                    columns[j][num] = true;
                    grids[(i / 3) * 3 + j / 3][num] = true;
                }
            }
        }

        // Calculate candidates for each empty cell.
        for (Cell cell : emptyCells) {
            cell.candidates = getCandidates(cell.row, cell.col, rows, columns, grids);
        }

        // Sort by the number of candidates to apply MRV heuristic.
        Collections.sort(emptyCells, Comparator.comparingInt(a -> Integer.bitCount(a.candidates)));

        backTrackSolveSudoku(board, rows, columns, grids, emptyCells, 0);
    }

    private boolean backTrackSolveSudoku(char[][] board, boolean[][] rows, boolean[][] columns, boolean[][] grids, List<Cell> emptyCells, int index) {
        if (index == emptyCells.size()) {
            return true;
        }

        Cell cell = emptyCells.get(index);
        int row = cell.row, col = cell.col;
        for (int num = 1; num <= 9; num++) {
            if (isSafe(num, row, col, rows, columns, grids)) {
                board[row][col] = (char) (num + '0');
                rows[row][num - 1] = true;
                columns[col][num - 1] = true;
                grids[(row / 3) * 3 + col / 3][num - 1] = true;

                if (backTrackSolveSudoku(board, rows, columns, grids, emptyCells, index + 1)) {
                    return true;
                }

                // Undo the move.
                rows[row][num - 1] = false;
                columns[col][num - 1] = false;
                grids[(row / 3) * 3 + col / 3][num - 1] = false;
                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean isSafe(int num, int row, int col, boolean[][] rows, boolean[][] columns, boolean[][] grids) {
        return !rows[row][num - 1] && !columns[col][num - 1] && !grids[(row / 3) * 3 + col / 3][num - 1];
    }

    private int getCandidates(int row, int col, boolean[][] rows, boolean[][] columns, boolean[][] grids) {
        int candidates = 0;
        for (int num = 1; num <= 9; num++) {
            if (!rows[row][num - 1] && !columns[col][num - 1] && !grids[(row / 3) * 3 + col / 3][num - 1]) {
                candidates |= (1 << (num - 1));
            }
        }
        return candidates;
    }
}
// @lc code=end
