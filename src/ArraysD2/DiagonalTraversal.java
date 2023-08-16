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

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] diagonal = getDiagonal(arr, arr.length, arr[0].length);
        for (int num: diagonal) {
            System.out.print(num + " ");
        }
    }
}
