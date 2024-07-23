package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class KnightsTour {

    private static final int N = 8;

    private static final int[][] board = new int[N][N];

    private static int moveCount = 0;

    public static void main(String[] args) {

        int startRow = 0, startCol = 0;

        if (solve(startRow, startCol, 1)) {
            System.out.println("Number of moves: " + moveCount);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution found.");
        }
    }

    private static List<int[]> validMoves(int row, int col) {
        List<int[]> moves = new ArrayList<>();
        int[] rowMoves = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] colMoves = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + rowMoves[i];
            int newCol = col + colMoves[i];
            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N && board[newRow][newCol] == 0) {
                moves.add(new int[]{newRow, newCol});
            }
        }
        return moves;
    }

    private static boolean solve(int row, int col, int moveNum) {
        board[row][col] = moveNum;
        moveCount++;

        if (moveNum == N * N) {
            return true;
        }

        List<int[]> moves = validMoves(row, col);
        for (int[] move : moves) {
            int newRow = move[0];
            int newCol = move[1];
            if (solve(newRow, newCol, moveNum + 1)) {
                return true;
            }
        }

        board[row][col] = 0;
        moveCount--;
        return false;
    }
}
