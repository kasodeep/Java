package dp.adjacentproblems;

/**
 * We can let the nth friend be single, so n - 1 remaining.
 * Else pair with any of the n - 1 friends then we left with n - 2 friends.
 */
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
