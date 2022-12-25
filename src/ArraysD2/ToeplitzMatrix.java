package ArraysD2;

public class ToeplitzMatrix {

    static boolean checkToeplitz(int[][] matrix, int r, int c) {

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < r; j++) {
                if (matrix[i][j] != matrix[j - 1][i - 1])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
