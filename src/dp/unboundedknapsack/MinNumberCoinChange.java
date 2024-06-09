package dp.unboundedknapsack;

import java.util.Arrays;

public class MinNumberCoinChange {

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int num : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= num && dp[i - num] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - num]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
