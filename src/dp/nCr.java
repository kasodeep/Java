package dp;

import java.util.Arrays;

public class nCr {

    static final int mod = 1000000007;

    static int solve(int n, int r, int[][] dp) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;

        if (dp[n][r] != -1) return dp[n][r];
        return dp[n][r] = (solve(n - 1, r, dp) + solve(n - 1, r - 1, dp)) % mod;
    }

    public static int ncr(int n, int r) {
        int[][] dp = new int[n + 1][r + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n, r, dp);
    }
}
