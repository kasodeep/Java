package dp.unboundedknapsack;

public class CoinChangeProblem {

    public static long count(int[] coins, int N, int sum) {
        long[][] dp = new long[N + 1][sum + 1];

        for (int i = 0; i <= N; i++) dp[i][0] = 1;
        for (int i = 1; i <= sum; i++) dp[0][i] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][sum];
    }
}
