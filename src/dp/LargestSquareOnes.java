package dp;

public class LargestSquareOnes {

    static int maxSquare(int n, int m, int[][] matrix) {
        int maxAns = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0 && j > 0 && matrix[i][j] != 0)
                    matrix[i][j] = Math.min(matrix[i][j - 1], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j])) + 1;

                maxAns = Math.max(maxAns, matrix[i][j]);
            }
        }
        return maxAns;
    }
}
