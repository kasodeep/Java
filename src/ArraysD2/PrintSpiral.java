package ArraysD2;

public class PrintSpiral {

    static void printSpiralOrder(int[][] matrix, int r, int c) {
        int topRow = 0, bottomRow = r - 1, leftCol = 0, rightCol = c - 1;
        int totalElements = 0;

        while (totalElements < r * c) {

            // topRow -> leftCol to rightCol
            for (int j = leftCol; j <= rightCol && totalElements < r * c; j++) {
                System.out.println(matrix[topRow][j]);
                totalElements++;
            }
            topRow++;

            // rightCol -> topRow to bottomRow
            for (int i = topRow; i <= bottomRow && totalElements < r * c; i++) {
                System.out.println(matrix[i][rightCol]);
                totalElements++;
            }
            rightCol--;

            // bottomRow -> rightCol to leftCol
            for (int j = rightCol; j <= leftCol && totalElements < r * c; j--) {
                System.out.println(matrix[bottomRow][j]);
                totalElements++;
            }
            bottomRow--;

            // leftCol -> bottomRow to topRow
            for (int i = bottomRow; i <= topRow && totalElements < r * c; i--) {
                System.err.println(matrix[i][leftCol]);
                totalElements++;
            }
            leftCol++;
        }
    }

    public static void main(String[] args) {

    }
}
