package ArraysD2;

public class SetMatrixZeros {

    static private boolean[][] isVisited;

    public static void set(int[][] matrix, int i, int j) {
        if (isVisited[i][j]) return;
        isVisited[i][j] = true;

        // Go up in a column.
        int temp = j;
        while (temp >= 0) {
            if (matrix[i][temp] == 0) {
                temp--;
                continue;
            }
            matrix[i][temp] = 0;
            isVisited[i][temp--] = true;
        }

        // Go down in a column.
        temp = j;
        while (temp < matrix[0].length) {
            if (matrix[i][temp] == 0) {
                temp++;
                continue;
            }
            matrix[i][temp] = 0;
            isVisited[i][temp++] = true;
        }

        // Go left in a column.
        temp = i;
        while (temp >= 0) {
            if (matrix[temp][j] == 0) {
                temp--;
                continue;
            }
            matrix[temp][j] = 0;
            isVisited[temp--][j] = true;
        }

        // Go right in a column.
        temp = i;
        while (temp < matrix.length) {
            if (matrix[temp][j] == 0) {
                temp++;
                continue;
            }
            matrix[temp][j] = 0;
            isVisited[temp++][j] = true;
        }
    }

    public static void setZeroes(int[][] matrix) {
        isVisited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    set(matrix, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 3, 4, 0}, {1, 2, 3, 4}, {2, 3, 4, 5}};
        setZeroes(matrix);

        for (int[] num : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(num[j] + " ");
            }
            System.out.println();
        }
    }
}
