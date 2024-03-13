package ArraysD2;

public class DiagonalTraversal {

    static int[] getDiagonal(int[][] matrix, int r, int c) {
        int[] ans = new int[r * c];
        int index = 0, row = 0, col = 0;

        while (col < c) {
            int i = row, j = col;
            while (i >= 0 && j < c) {
                ans[index++] = matrix[i--][j++];
            }
            row++;
            if (row >= r) {
                row = r - 1;
                col++;
            }
        }
        return ans;
    }

    public static int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int[] res = new int[n * n];

        int row = 0, col = 0;
        for (int i = 0; i < n * n; i++) {
            res[i] = mat[row][col];

            // If sum of row and col is even, move up-right.
            if ((row + col) % 2 == 0) {
                if (col == n - 1) {
                    row++;
                } else if (row == 0) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            }
            // If sum of row and col is odd, move down-left.
            else {
                if (row == n - 1) {
                    col++;
                } else if (col == 0) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] diagonal = getDiagonal(arr, arr.length, arr[0].length);
        for (int num : diagonal) {
            System.out.print(num + " ");
        }
    }
}
