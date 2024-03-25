package dp.gridproblems;

public class MaxSumPathRow {

    static int maximumPath(int N, int[][] arr) {
        int[][] dp = new int[N][N];
        int mx = Integer.MIN_VALUE;

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1) dp[i][j] = arr[i][j];

                else if (j == 0) dp[i][j] = arr[i][j] + Math.max(dp[i + 1][j], j + 1 < N ? dp[i + 1][j + 1] : 0);
                else if (j == N - 1) dp[i][j] = arr[i][j] + Math.max(dp[i + 1][j - 1], dp[i + 1][j]);

                else dp[i][j] = arr[i][j] + Math.max(dp[i + 1][j], Math.max(dp[i + 1][j - 1], dp[i + 1][j + 1]));
                mx = Math.max(mx, dp[i][j]);
            }
        }
        return mx;
    }
}
