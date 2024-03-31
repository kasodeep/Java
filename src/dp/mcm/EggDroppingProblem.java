package dp.mcm;

import java.util.Arrays;

public class EggDroppingProblem {

    static int eggDrop(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int[] temp : dp) Arrays.fill(temp, -1);
        return solve(n, k, dp);
    }

    static int solve(int e, int f, int[][] dp) {
        if (f == 0 || f == 1) return f;
        if (e == 1) return f;
        if (dp[e][f] != -1) return dp[e][f];

        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int temp1 = solve(e - 1, k - 1, dp);
            int temp2 = solve(e, f - k, dp);
            min = Math.min(min, Math.max(temp1, temp2) + 1);
        }

        return dp[e][f] = min;
    }
}
