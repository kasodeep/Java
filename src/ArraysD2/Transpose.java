package ArraysD2;

public class Transpose {

    static void transposeInPlace(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = i; j < c; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    static void print2DArray(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        for (int[] num : matrix) {
            for (int j = 0; j < c; j++) {
                System.out.print(num[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        transposeInPlace(arr);
        print2DArray(arr);
    }
}
