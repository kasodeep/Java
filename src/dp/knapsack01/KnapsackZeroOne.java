package dp.knapsack01;

import java.util.Arrays;

public class KnapsackZeroOne {

    static int[][] memo;

    static int knapSack(int W, int[] wt, int[] val, int n) {
        memo = new int[n + 1][W + 1];
        for (int[] arr : memo) Arrays.fill(arr, -1);

        int ans = solve(wt, val, 0, W, n);
        return ans == -1 ? 0 : ans;
    }

    static int solve(int[] wt, int[] val, int i, int W, int n) {
        if (i >= n) return 0;
        if (W <= 0) return 0;

        if (memo[i][W] != -1) return memo[i][W];
        if (W - wt[i] >= 0) memo[i][W] = val[i] + solve(wt, val, i + 1, W - wt[i], n);

        memo[i][W] = Math.max(memo[i][W], solve(wt, val, i + 1, W, n));
        return memo[i][W];
    }
}
