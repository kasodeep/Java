package BackTracking;

public class NQueens {

   /*
    * Helper Function to find if there is a possible combination to fint the
    * arrangement.
    */
   public static void nqueen(char[][] board, int row) {
      int n = board.length;

      // Print the solution, Base case
      if (row == n) {
         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
               System.out.print(board[i][j]);
            }
            System.out.println();
         }
         System.out.println();
         return;
      }

      // Iterate over the board row.
      for (int j = 0; j < n; j++) {
         if (isSafe(board, row, j)) {
            board[row][j] = 'Q';
            nqueen(board, row + 1);
            board[row][j] = 'X'; // backtracking
         }
      }
   }

   /*
    * Helper function to check if the queen is safe to place.
    */
   public static boolean isSafe(char[][] board, int row, int col) {

      // Horizontal
      for (int j = 0; j < board.length; j++) {
         if (board[row][j] == 'Q') {
            return false;
         }
      }

      // Vertical
      for (int i = 0; i < board.length; i++) {
         if (board[i][col] == 'Q') {
            return false;
         }
      }

      // Upper left
      for (int c = col, r = row; c >= 0 && r >= 0; c--, r--) {
         if (board[r][c] == 'Q') {
            return false;
         }
      }

      // Upper right
      for (int c = col, r = row; c < board.length && r >= 0; r--, c++) {
         if (board[r][c] == 'Q') {
            return false;
         }
      }

      // Lower left
      for (int c = col, r = row; c >= 0 && r < board.length; r++, c--) {
         if (board[r][c] == 'Q') {
            return false;
         }
      }

      // Lower right
      for (int c = col, r = row; c < board.length && r < board.length; c++, r++) {
         if (board[r][c] == 'Q') {
            return false;
         }
      }

      return true;
   }

   /*
    * Arrange n queens in a nxn chess board, such that they do not attack each
    * other.
    * Here we are iterating over board row since we are sure that every row has
    * only one queen.
    */
   public static void main(String[] args) {
      int n = 4;
      char[][] board = new char[n][n];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            board[i][j] = 'X';
         }
      }
      nqueen(board, 0);
   }
}
