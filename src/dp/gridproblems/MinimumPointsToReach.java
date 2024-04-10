package dp.gridproblems;

import java.util.Arrays;

public class MinimumPointsToReach {

    static int[][] dp;

    public static int dfs(int i, int j, int[][] arr, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return arr[i][j] > 0 ? 1 : Math.abs(arr[i][j]) + 1;
        }

        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int ans = Integer.MAX_VALUE;

        if (j + 1 < m) {
            int x = -arr[i][j] + dfs(i, j + 1, arr, n, m);
            ans = Math.min(ans, x);
        }

        if (i + 1 < n) {
            int y = -arr[i][j] + dfs(i + 1, j, arr, n, m);
            ans = Math.min(ans, y);
        }

        return dp[i][j] = ans <= 0 ? 1 : ans;
    }

    public int minPoints(int[][] points, int n, int m) {
        dp = new int[n + 1][m + 1];
        for (int[] temp : dp) Arrays.fill(temp, Integer.MIN_VALUE);

        return dfs(0, 0, points, n, m);
    }
}
