package Daily.GfG;

public class ShortestCommonSuperSequence {

    public static int shortestCommonSupersequence(String X, String Y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = X.charAt(i - 1) == Y.charAt(j - 1) ? 1 + dp[i - 1][j - 1] : Math.max(dp[i - 1][j], dp[i][j - 1]);
        return n + m - dp[m][n];
    }

    public static void main(String[] args) {

    }
}
