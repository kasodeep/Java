package dp.knapsack01;

import java.util.Arrays;

/**
 * Find the two subsets of the array that have the same sum.
 */
public class EqualSubsetSum {

    static int[][] dp;

    static int equalPartition(int N, int[] arr) {
        int sum = 0;
        for (int i = 0; i < N; i++) sum += arr[i];
        if (sum % 2 != 0) return 0;

        dp = new int[N + 1][sum / 2 + 1];
        for (int[] temp : dp) Arrays.fill(temp, -1);

        int ans = solve(0, sum / 2, N, arr);
        return ans == -1 ? 0 : ans;
    }

    static int solve(int i, int sum, int N, int[] arr) {
        if (i == N) return 0;
        if (sum < 0) return 0;
        if (sum == 0) return 1;

        if (dp[i][sum] != -1) return dp[i][sum];
        dp[i][sum] = solve(i + 1, sum - arr[i], N, arr) | solve(i + 1, sum, N, arr);
        return dp[i][sum];
    }
}
