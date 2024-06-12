package dp.commonsubsequence;

import java.util.Arrays;

/**
 * Subtraction is the crazy part!
 */
public class CountPalindromicSubsequence {

    static long mod = 1000000007;

    static long countPS(String S) {
        int n = S.length();
        long[][] dp = new long[n + 1][n + 1];
        for (long[] temp : dp) Arrays.fill(temp, -1);

        return solve(S, 0, n - 1, dp);
    }

    public static long solve(String s, int i, int j, long[][] dp) {
        if (j == i) return 1;
        if (j < i) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == s.charAt(j))
            return dp[i][j] = (1 + (solve(s, i, j - 1, dp) % mod) + (solve(s, i + 1, j, dp) % mod)) % mod;
        else
            return dp[i][j] = ((solve(s, i + 1, j, dp) % mod) + (solve(s, i, j - 1, dp) % mod) - (solve(s, i + 1, j - 1, dp) % mod) + mod) % mod;
    }
}
