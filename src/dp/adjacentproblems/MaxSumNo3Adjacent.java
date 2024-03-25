package dp.adjacentproblems;

public class MaxSumNo3Adjacent {

    static int findMaxSum(int[] arr, int n) {
        if (n == 1) return arr[0];
        if (n == 2) return arr[0] + arr[1];

        int[] dp = new int[n + 1];
        dp[1] = arr[0];
        dp[2] = arr[0] + arr[1];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], (Math.max(dp[i - 2], arr[i - 2] + dp[i - 3]) + arr[i - 1]));
        }
        return dp[n];
    }
}
