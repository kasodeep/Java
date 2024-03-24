package dp.commonsubsequence;

import java.util.Arrays;

public class LongestRepeatingSubsequence {

    public static int f(int i, int j, String str, String txt, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (str.charAt(i) == txt.charAt(j) && i != j) {
            return dp[i][j] = 1 + f(i - 1, j - 1, str, txt, dp);
        }
        return dp[i][j] = Math.max(f(i - 1, j, str, txt, dp), f(i, j - 1, str, txt, dp));
    }

    public static int longestRepeatingSubsequence(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int[] row : dp) Arrays.fill(row, -1);
        return f(n - 1, n - 1, str, str, dp);
    }
}
