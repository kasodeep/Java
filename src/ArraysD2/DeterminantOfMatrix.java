package ArraysD2;

public class DeterminantOfMatrix {

    static int determinantOfMatrix(int[][] matrix, int n) {
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];

        int det = 0;
        for (int i = 0, sign = 1; i < n; i++, sign = -sign) {
            int[][] b = new int[n - 1][n - 1];
            int a = 0;

            // Copying the smaller matrix.
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 1; k < n; k++)
                    b[k - 1][a] = matrix[k][j];
                a++;
            }

            det += sign * matrix[0][i] * determinantOfMatrix(b, n - 1);
        }
        return det;
    }

    public static void main(String[] args) {

    }
}
