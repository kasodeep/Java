package dp;

import java.util.Arrays;

public class StudentAttendance2 {

    static int MOD = 1000000007;

    public static int checkRecord(int n) {
        int[][][] dp = new int[n + 1][2][3];
        for (int[][] outer : dp)
            for (int[] inner : outer) Arrays.fill(inner, -1);

        return solve(0, 0, 0, n, dp) % MOD;
    }

    public static int solve(int p, int a, int l, int n, int[][][] dp) {
        if (p == n) return 1;
        if (dp[p][a][l] != -1) return dp[p][a][l];

        int ans = 0;
        ans = (ans + solve(p + 1, a, 0, n, dp)) % MOD;

        if (a == 0)
            ans = (ans + solve(p + 1, a + 1, 0, n, dp)) % MOD;

        if (l < 2)
            ans = (ans + solve(p + 1, a, l + 1, n, dp)) % MOD;

        return dp[p][a][l] = (ans % MOD);
    }
}
