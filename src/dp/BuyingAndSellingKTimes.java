package dp;

public class BuyingAndSellingKTimes {

    static int maxProfit(int K, int N, int[] A) {
        int profit = 0;
        int[][] dp = new int[K + 1][N];

        for (int i = 1; i <= K; i++) {
            int maxV = Integer.MIN_VALUE;
            for (int j = 1; j < N; j++) {
                dp[i][j] = dp[i][j - 1];
                if (dp[i - 1][j - 1] - A[j - 1] > maxV) maxV = dp[i - 1][j - 1] - A[j - 1];
                dp[i][j] = Math.max(dp[i][j], maxV + A[j]);
            }
        }
        return dp[K][N - 1];
    }
}
