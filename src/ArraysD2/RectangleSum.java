package ArraysD2;

public class RectangleSum {

    static void prefixSum(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        for (int j = 0; j < c; j++) {
            for (int i = 1; i < r; i++) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }
    }

    static int sum(int[][] matrix, int l1, int r1, int l2, int r2) {
        prefixSum(matrix);
        int left = 0, up = 0, leftUp = 0;

        if (l1 >= 1)
            up = matrix[l1 - 1][r2];
        if (r1 >= 1)
            left = matrix[l2][r1 - 1];
        if (l1 >= 1 && r1 >= 1)
            leftUp = matrix[l1 - 1][r1 - 1];
        return matrix[l2][r2] - left - up + leftUp;
    }

    public static void main(String[] args) {

    }

}
