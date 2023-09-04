package ArraysD2;

public class GenerateSpiral {

    static int[][] generateSpiralMatrix(int n) {
        int[][] matrix = new int[n][n];
        int topRow = 0, bottomRow = n - 1, leftCol = 0, rightCol = n - 1;
        int totalElements = 1;

        while (totalElements <= n * n) {

            // topRow -> leftCol to rightCol
            for (int j = leftCol; j <= rightCol && totalElements <= n * n; j++) {
                matrix[topRow][j] = totalElements;
                totalElements++;
            }
            topRow++;

            // rightCol -> topRow to bottomRow
            for (int i = topRow; i <= bottomRow && totalElements <= n * n; i++) {
                matrix[i][rightCol] = totalElements;
                totalElements++;
            }
            rightCol--;

            // bottomRow -> rightCol to leftCol
            for (int j = rightCol; j >= leftCol && totalElements <= n * n; j--) {
                matrix[bottomRow][j] = totalElements;
                totalElements++;
            }
            bottomRow--;

            // leftCol -> bottomRow to topRow
            for (int i = bottomRow; i >= topRow && totalElements <= n * n; i--) {
                matrix[i][leftCol] = totalElements;
                totalElements++;
            }
            leftCol++;
        }

        return matrix;
    }

    public static void main(String[] args) {

    }
}
