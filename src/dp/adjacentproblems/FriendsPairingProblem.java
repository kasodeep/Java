package dp.adjacentproblems;

public class FriendsPairingProblem {

    public static long countFriendsPairings(int n) {
        long[] dp = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i <= 2) {
                dp[i] = i;
            } else {
                dp[i] = (dp[i - 1] + (i - 1) * dp[i - 2]) % 1000000007;
            }
        }
        return dp[n] % 1000000007;
    }
}
