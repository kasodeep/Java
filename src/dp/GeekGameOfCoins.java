package dp;

public class GeekGameOfCoins {

    public int findWinner(int N, int X, int Y) {
        boolean[] dp = new boolean[N + 1];
        dp[0] = false;
        dp[1] = true;

        for (int i = 2; i <= N; i++) {
            if (!dp[i - 1]) {
                dp[i] = true;
            } else if (i - X >= 0 && !dp[i - X]) {
                dp[i] = true;
            } else dp[i] = i - Y >= 0 && !dp[i - Y];
        }

        return dp[N] ? 1 : 0;
    }
}
