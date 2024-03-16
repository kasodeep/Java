package dp.commonsubsequence;

import java.util.Arrays;

public class EditDistance {

    public static int editDistance(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] temp : dp) Arrays.fill(temp, Integer.MAX_VALUE);
        return solve(0, 0, s, t, dp);
    }

    public static int solve(int i, int j, String s, String t, int[][] dp) {
        if (i == s.length()) return t.length() - j;
        if (j == t.length()) return s.length() - i;

        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = solve(i + 1, j + 1, s, t, dp);
        }

        return dp[i][j] = 1 + Math.min(solve(i + 1, j, s, t, dp), Math.min(solve(i + 1, j + 1, s, t, dp), solve(i, j + 1, s, t, dp)));
    }
}
