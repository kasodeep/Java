package dp.gridproblems;

public class MatricesSquareCount {

    public int countSquares(int[][] a) {
        int count = 0;
        int N = a.length;
        int M = a[0].length;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (a[i][j] == 0) continue;
                a[i][j] = Math.min(Math.min(a[i - 1][j], a[i][j - 1]), a[i - 1][j - 1]) + 1;
            }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                count += a[i][j];
        return count;
    }
}
