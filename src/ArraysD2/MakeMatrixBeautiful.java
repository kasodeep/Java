package ArraysD2;

public class MakeMatrixBeautiful {

    public static int findMinOperation(int N, int[][] matrix) {

        int max = Integer.MIN_VALUE, ans = 0;
        for (int i = 0; i < N; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < N; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            max = Math.max(max, Math.max(rowSum, colSum));
        }

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += matrix[i][j];
            }
            ans += max - sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 2, 3}, {3, 2, 1}};
        System.out.println(findMinOperation(3, matrix));
    }
}
