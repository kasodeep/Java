package BackTracking;

public class SudokuSolver {

    public static boolean isValid(int[][] board, int row, int col, int num) {
        // Check Row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }

        // Check Column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 Grid
        int sRow = row / 3 * 3;
        int sCol = col / 3 * 3;
        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean SolveSudoku(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {

                    for (int k = 1; k <= 9; k++) {
                        if (isValid(grid, i, j, k)) {
                            grid[i][j] = k;

                            if (SolveSudoku(grid)) {
                                return true;
                            } else {
                                grid[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static void printGrid(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i == grid.length - 1 && j == grid.length - 1) {
                    System.out.print(grid[i][j]);
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
        }
    }
}
