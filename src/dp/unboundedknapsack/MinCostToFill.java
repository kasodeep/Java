package dp.unboundedknapsack;

import java.util.Arrays;

public class MinCostToFill {

    public static int minimumCost(int[] cost, int N, int W) {
        long[][] dp = new long[N + 1][W + 1];
        for (long[] temp : dp) Arrays.fill(temp, -1);

        long res = solve(0, N, W, cost, dp);
        return res >= Integer.MAX_VALUE ? -1 : (int) res;
    }

    public static long solve(int i, int n, int w, int[] cost, long[][] dp) {
        if (w == 0) return 0;
        if (i == n) return Integer.MAX_VALUE;
        if (dp[i][w] != -1) return dp[i][w];

        if (w >= i + 1 && cost[i] != -1) {
            return dp[i][w] = Math.min(cost[i] + solve(i, n, w - (i + 1), cost, dp), solve(i + 1, n, w, cost, dp));
        }
        return dp[i][w] = solve(i + 1, n, w, cost, dp);
    }
}
