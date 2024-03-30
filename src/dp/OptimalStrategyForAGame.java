package dp;

import java.util.Arrays;

public class OptimalStrategyForAGame {

    public static long memo(int st, int end, int[] arr, long[][] dp) {
        if (st > end) return 0;
        if (dp[st][end] != -1) return dp[st][end];

        long first = arr[st] + Math.min(memo(st + 1, end - 1, arr, dp), memo(st + 2, end, arr, dp));
        long sec = arr[end] + Math.min(memo(st + 1, end - 1, arr, dp), memo(st, end - 2, arr, dp));

        return dp[st][end] = Math.max(first, sec);
    }

    public static long countMaximum(int n, int[] arr) {
        long[][] dp = new long[n + 1][n + 1];
        for (long[] row : dp) Arrays.fill(row, -1);

        return memo(0, arr.length - 1, arr, dp);
    }

    public static boolean predictTheWinner(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        return getScore(0, nums.length - 1, nums, memo) >= 0;
    }

    private static int getScore(int i, int j, int[] nums, int[][] memo) {
        if (i == j) return nums[i];

        if (memo[i][j] != 0) return memo[i][j];

        int iScore = nums[i] - getScore(i + 1, j, nums, memo);
        int jScore = nums[j] - getScore(i, j - 1, nums, memo);

        return memo[i][j] = Math.max(iScore, jScore);
    }
}
