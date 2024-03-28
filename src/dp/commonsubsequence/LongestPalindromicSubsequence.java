package dp.commonsubsequence;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    public static int longestPalindromicSubSeq(String S) {
        int n = S.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int[] temp : dp) Arrays.fill(temp, -1);

        return solve(S, 0, n - 1, dp);
    }

    public static int solve(String s, int i, int j, int[][] dp) {
        if (j == i) return 1;
        if (j < i) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + solve(s, i + 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(solve(s, i + 1, j, dp), solve(s, i, j - 1, dp));
        }
    }
}
