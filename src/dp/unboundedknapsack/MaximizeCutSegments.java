package dp.unboundedknapsack;

public class MaximizeCutSegments {

    public static int maximizeCuts(int n, int x, int y, int z) {
        int[] cuts = {x, y, z};
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int cut : cuts) {
                if (i - cut >= 0 && dp[i - cut] != Integer.MIN_VALUE) {
                    dp[i] = Math.max(dp[i], dp[i - cut] + 1);
                }
            }
        }
        return dp[n] == Integer.MIN_VALUE ? 0 : dp[n];
    }
}
