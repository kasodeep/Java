package BackTracking;

public class SudokuSolver {

   // Once the solution is created, we set it to 1;
   static int check = 0;

   /*
    * Function to check whether the number is at a valid position.
    */
   public boolean isValid(char[][] board, int row, int col, char num) {
      // Check Row
      for (int j = 0; j < 9; j++) {
         if (board[row][j] == num)
            return false;
      }

      // Check Column
      for (int i = 0; i < 9; i++) {
         if (board[i][col] == num)
            return false;
      }

      // Chech 3x3 Grid
      int sRow = row / 3 * 3;
      int sCol = col / 3 * 3;
      for (int i = sRow; i < sRow + 3; i++) {
         for (int j = sCol; j < sCol + 3; j++) {
            if (board[i][j] == num)
               return false;
         }
      }
      return true;
   }

   /*
    * Solving the Sudoku problem
    */
   public void solve(char[][] board, int row, int col) {
      if (row == 9) {
         check = 1;
         return;
      } else if (board[row][col] != '.') {
         if (col != 8)
            solve(board, row, col + 1);
         else
            solve(board, row + 1, 0);
      } else {
         for (char ch = '1'; ch <= '9'; ch++) {
            if (isValid(board, row, col, ch)) {
               board[row][col] = ch;

               if (col != 8)
                  solve(board, row, col + 1);
               else
                  solve(board, row + 1, 0);
               if (check == 1)
                  return;

               board[row][col] = '.';
            }
         }
      }
   }

   public void solveSudoku(char[][] board) {
      check = 0;
      solve(board, 0, 0);
   }

   public static void main(String[] args) {

   }
}
