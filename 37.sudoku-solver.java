/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {

        // int count = countEmptyCells(board);

        backTrackSolveSudoku(0, 0, board);
    }

    // public void showBoard(char[][] board) {
    //     for (int i = 0; i < 9; i++)
    //         for (int j = 0; j < 9; j++) 
    //             System.out.print(board[i][j]+",");
    // }

    // public void showCells(char[] cells) {
    //     for (int i = 0; i < 9; i++)
    //         System.out.print(cells[i]+",");
    // }

    // public int countEmptyCells(char[][] board) {
    //     int count = 0;
    //     for (int i = 0; i < 9; i++) 
    //         for (int j = 0; j < 9; j++) 
    //             if (board[i][j] == '.') count++;
            
    //     return count;
    // }

    public boolean backTrackSolveSudoku(int i, int j, char[][] board) {
        for (; i < 9; i++) {
            for (; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (backTrackSolveSudoku(i, j, board)) 
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
    
    public boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false; // 检查行
            if (board[row][i] != '.' && board[row][i] == c) return false; // 检查列
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; // 检查3*3方块
        }
        return true;
    }

    // public boolean checkBoard(int i, int j, char[][] board) {
    //     int row = i / 3;
    //     int column = j / 3;
    //     int index = 3 * row + column;
    //     if (!checkSquare(index, board)) return false;
    //     if (!checkRow(i, board)) return false;
    //     if (!checkColumn(j, board)) return false;
        

    //     return true;
    // }

    // public boolean checkSquare(int index, char[][] board) {
    //     int row = index / 3;
    //     int column = index % 3;
    //     char[] square = new char[9];

    //     for (int i = 0 + row * 3; i < 3 + row * 3; i++) {
    //         for (int j = 0 + column * 3; j < 3 + column * 3; j++) {
    //             square[(i - row * 3) * 3 + (j - column * 3)] = board[i][j];
    //         }
    //     }

    //     return isValid(square);
    // }

    // public boolean checkRow(int rowIndex, char[][] board) {
    //     char[] row = new char[9];

    //     for (int i = 0; i < 9; i++) 
    //         row[i] = board[rowIndex][i];

    //     return isValid(row);
    // }

    // public boolean checkColumn(int columnIdex, char[][] board) {
    //     char[] column = new char[9];

    //     for (int i = 0; i < 9; i++)
    //         column[i] = board[i][columnIdex];

    //     return isValid(column);
    // }

    // public boolean isValid (char[] collection) {
    //     Set<Character> set = new HashSet<Character>();
    //     for (char i : collection) {
    //         if (i == '.') {
    //             continue;
    //         }
    //         if (!set.add(i)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
// @lc code=end

