package dp;

import java.util.Arrays;

public class BuyingAndSellingKTimes {

    public static int maximumProfit(int[] prices, int n, int k) {
        int[][][] dp = new int[n][2][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return getAns(prices, n, 0, 0, k, dp);
    }

    public static int getAns(int[] prices, int n, int ind, int buy, int cap, int[][][] dp) {
        if (ind == n || cap == 0) return 0;
        if (dp[ind][buy][cap] != -1) return dp[ind][buy][cap];

        int profit;
        if (buy == 0) {
            profit = Math.max(getAns(prices, n, ind + 1, 0, cap, dp), -prices[ind] + getAns(prices, n, ind + 1, 1, cap, dp));
        } else {
            profit = Math.max(getAns(prices, n, ind + 1, 1, cap, dp), prices[ind] + getAns(prices, n, ind + 1, 0, cap - 1, dp));
        }

        dp[ind][buy][cap] = profit;
        return profit;
    }
}
