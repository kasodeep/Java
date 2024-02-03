package dp.unboundedknapsack;

public class MinNumberCoinChange {

    public static int minCoins(int[] coins, int N, int V) {
        int[][] dp = new int[N + 1][V + 1];

        for (int i = 0; i <= N; i++)
            dp[i][0] = 0;
        for (int i = 1; i <= V; i++)
            dp[0][i] = Integer.MAX_VALUE - 1;

        for (int j = 1; j <= V; j++) {
            if (j % coins[0] == 0) dp[1][j] = j / coins[0];
            else dp[1][j] = Integer.MAX_VALUE - 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][V] == Integer.MAX_VALUE - 1 ? -1 : dp[N][V];
    }
}
