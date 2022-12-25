package ArraysD2;

public class DiagonalMatrix {

    static boolean checkDiagonal(int[][] matrix, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    if (matrix[i][j] == 0)
                        return false;
                }
                if (matrix[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
