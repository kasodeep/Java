package dp.unboundedknapsack;

public class CoinChangeProblem {

    static int mod = 1000000007;

    public static int count(int[] coins, int n, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coins[j]) {
                    dp[i] = (dp[i] + dp[i - coins[j]]) % mod;
                }
            }
        }
        return dp[sum];
    }
}
