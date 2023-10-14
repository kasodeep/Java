package Daily.LeetCode;

/**
 * You are given two 0-indexed integer arrays, cost and time, of size n,
 * representing the costs and the time taken to paint n different walls respectively.
 */
public class PaintingTheWalls {

    static int[][] memo;
    static int n;

    public static int paintWallsTwo(int[] cost, int[] time) {
        n = cost.length;
        memo = new int[n][n + 1];
        return dp(0, n, cost, time);
    }

    public static int dp(int i, int remain, int[] cost, int[] time) {
        if (remain <= 0) return 0;
        if (i == n) return (int) 1e9;

        if (memo[i][remain] != 0) {
            return memo[i][remain];
        }

        int paint = cost[i] + dp(i + 1, remain - 1 - time[i], cost, time);
        int notPaint = dp(i + 1, remain, cost, time);
        memo[i][remain] = Math.min(paint, notPaint);
        return memo[i][remain];
    }

    public static int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[n][i] = (int) 1e9;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int remain = 1; remain <= n; remain++) {
                int paint = cost[i] + dp[i + 1][Math.max(0, remain - 1 - time[i])];
                int notPaint = dp[i + 1][remain];
                dp[i][remain] = Math.min(paint, notPaint);
            }
        }
        return dp[0][n];
    }

    public static void main(String[] args) {
        int[] cost = {1, 2, 3, 2};
        int[] time = {1, 2, 3, 2};
        System.out.println(paintWalls(cost, time));
    }
}
