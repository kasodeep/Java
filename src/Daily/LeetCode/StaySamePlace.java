package Daily.LeetCode;

import java.util.Arrays;

public class StaySamePlace {

    static final int MOD = (int) 1e9 + 7;
    static int[][] memo;
    static int arrLen;

    public static int dp(int curr, int remain) {
        if (remain == 0) {
            if (curr == 0) return 1;
            else return 0;
        }

        if (memo[curr][remain] != -1) {
            return memo[curr][remain];
        }

        int ans = dp(curr, remain - 1);
        if (curr > 0) {
            ans = (ans + dp(curr - 1, remain - 1)) % MOD;
        }

        if (curr < arrLen - 1) {
            ans = (ans + dp(curr + 1, remain - 1)) % MOD;
        }

        memo[curr][remain] = ans;
        return ans;
    }

    public static int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps);
        memo = new int[arrLen][steps + 1];

        for (int[] row : memo) Arrays.fill(row, -1);
        return dp(0, steps);
    }

    public static void main(String[] args) {

    }
}
