package dp;

import java.util.Arrays;

public class BooleanParenthesize {

    static final int mod = 1003;

    public static int countWays(int N, String S) {
        int[][][] dp = new int[S.length() + 1][S.length() + 1][2];
        for (int[][] rows : dp) {
            for (int[] col : rows) Arrays.fill(col, -1);
        }

        return solve(S, 0, N - 1, 1, dp);
    }

    private static int solve(String S, int i, int j, int isTrue, int[][][] dp) {
        if (i > j) return 0;

        if (i == j)
            if (isTrue == 1) return (S.charAt(i) == 'T') ? 1 : 0;
            else return (S.charAt(i) == 'F') ? 1 : 0;

        if (dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        int ans = 0;

        for (int k = i + 1; k <= j - 1; k += 2) {
            int lT = solve(S, i, k - 1, 1, dp);
            int lF = solve(S, i, k - 1, 0, dp);
            int rT = solve(S, k + 1, j, 1, dp);
            int rF = solve(S, k + 1, j, 0, dp);

            if (S.charAt(k) == '&') {
                if (isTrue == 1) ans = ans + lT * rT;
                else ans = ans + (lT * rF) + (lF * rT) + (lF * rF);
            } else if (S.charAt(k) == '|') {
                if (isTrue == 1) ans = ans + (lT * rT) + (lF * rT) + (lT * rF);
                else ans = ans + (lF * rF);
            } else {
                if (isTrue == 1) ans = ans + (lT * rF) + (lF * rT);
                else ans = ans + (lF * rF) + (lT * rT);
            }
        }

        return dp[i][j][isTrue] = (ans % mod);
    }
}
