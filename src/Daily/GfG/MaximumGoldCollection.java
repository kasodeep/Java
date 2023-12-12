package Daily.GfG;

public class MaximumGoldCollection {

    public static int maxGold(int n, int m, int[][] arr) {
        int[][] dp = new int[n][m];
        int mx = Integer.MIN_VALUE;

        // Loop through the columns from right to left
        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (j == m - 1) dp[i][j] = arr[i][j];
                else if (i == 0) dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], i + 1 < n ? dp[i + 1][j + 1] : 0);
                else if (i == n - 1) dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j + 1], dp[i][j + 1]);
                else dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));

                mx = Math.max(mx, dp[i][j]);
            }
        }
        return mx;
    }

    public static void main(String[] args) {

    }
}
