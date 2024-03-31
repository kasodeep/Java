package dp.mcm;

import java.util.Arrays;

public class PalindromicPartitioning {

    private static int[][] dp;

    static int palindromicPartition(String str) {
        dp = new int[501][501];
        for (int[] temp : dp) Arrays.fill(temp, -1);
        return helper(str, 0, str.length() - 1);
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i <= j) if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }

    private static int helper(String s, int i, int j) {
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (isPalindrome(s, i, j)) return 0;

        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left, right;

            if (dp[i][k] != -1) left = dp[i][k];
            else left = helper(s, i, k);

            if (dp[k + 1][j] != -1) right = dp[k + 1][j];
            else right = helper(s, k + 1, j);

            int ans = 1 + left + right;
            mini = Math.min(mini, ans);
        }
        return dp[i][j] = mini;
    }
}
