package BackTracking;

public class KKnightsMax {

    static int maxKnights = -1;
    static int number = 8;

    private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        int i, j;

        // 2 Up 1 Right
        i = row - 2;
        j = col + 1;
        if (i >= 0 && j < n && board[i][j] == 'K')
            return false;
        // 2 Up 1 Left
        i = row - 2;
        j = col - 1;
        if (i >= 0 && j >= 0 && board[i][j] == 'K')
            return false;
        // 2 Down 1 Right
        i = row + 2;
        j = col + 1;
        if (i < n && j < n && board[i][j] == 'K')
            return false;
        // 2 Down 1 Left
        i = row + 2;
        j = col - 1;
        if (i < n && j >= 0 && board[i][j] == 'K')
            return false;

        // 2 Right 1 Down
        i = row + 1;
        j = col + 2;
        if (i < n && j < n && board[i][j] == 'K')
            return false;
        // 2 Right 1 Up
        i = row - 1;
        j = col + 2;
        if (i >= 0 && j < n && board[i][j] == 'K')
            return false;
        // 2 Left 1 Down
        i = row + 1;
        j = col - 2;
        if (i < n && j >= 0 && board[i][j] == 'K')
            return false;
        // 2 Left 1 Up
        i = row - 1;
        j = col - 2;
        return i < 0 || j < 0 || board[i][j] != 'K';
    }

    private static void nKnight(char[][] board, int row, int col, int num) {
        int n = board.length;

        // Base Case
        if (row == n) {
            maxKnights = Math.max(maxKnights, num);
            return;

        } else if (isSafe(board, row, col)) {
            board[row][col] = 'K';

            if (col != n - 1)
                nKnight(board, row, col + 1, num + 1);
            else
                nKnight(board, row + 1, 0, num + 1);

            board[row][col] = 'X'; // backtracking
        }

        // Always we will run this. Select / Don't Select.
        if (col != n - 1)
            nKnight(board, row, col + 1, num);
        else
            nKnight(board, row + 1, 0, num);
    }

    /*
     * Find the maximum number of knights that can be placed in the board of nxn
     * such that they don't attack each other.
     */
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        nKnight(board, 0, 0, 0);
        System.out.println(maxKnights);
    }
}
