package ArraysD2;

public class RotateBy90 {

    public static void rotate(int[][] arr, int N) {
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {

                // Saving top left corner.
                int temp = arr[i][j];

                // Putting bottom left corner to top left.
                arr[i][j] = arr[N - 1 - j][i];

                // Putting bottom right corner to bottom left.
                arr[N - 1 - j][i] = arr[N - 1 - i][N - 1 - j];

                // Putting top right to bottom right.
                arr[N - 1 - i][N - 1 - j] = arr[j][N - 1 - i];

                // Putting top left to top right.
                arr[j][N - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = 3;
        rotate(arr1, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }
}
