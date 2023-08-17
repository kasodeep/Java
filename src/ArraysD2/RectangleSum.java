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

    static int sum(int[][] matrix, int startRow, int startColumn, int endRow, int endColumn) {
        prefixSum(matrix);
        int left = 0, up = 0, leftUp = 0;

        if (startRow >= 1)
            up = matrix[startRow - 1][endColumn];

        if (startColumn >= 1)
            left = matrix[endRow][startColumn - 1];

        if (startRow >= 1 && startColumn >= 1)
            leftUp = matrix[startRow - 1][startColumn - 1];
        return matrix[endRow][endColumn] - left - up + leftUp;
    }

    static int sumTwo(int[][] matrix, int startRow, int startColumn, int endRow, int endColumn) {
        int sum = 0;
        while (startRow <= endRow) {
            int j = startColumn;
            while (j <= endColumn) {
                sum += matrix[startRow][j++];
            }
            startRow++;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
