package dp.mcm;

import java.util.Arrays;

public class MatrixChainMultiplication {

    static int[][] dp;

    static int matrixMultiplication(int n, int[] p) {
        dp = new int[n + 1][n + 1];
        for (int[] temp : dp) Arrays.fill(temp, -1);
        return mcm(p, 1, n - 1);
    }

    static int mcm(int[] p, int i, int j) {
        if (i >= j) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = mcm(p, i, k) + mcm(p, k + 1, j) + (p[i - 1] * p[k] * p[j]);
            ans = Math.min(ans, temp);
        }
        return dp[i][j] = ans;
    }
}
