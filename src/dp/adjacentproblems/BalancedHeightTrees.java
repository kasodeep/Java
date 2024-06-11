package dp.adjacentproblems;

/**
 * Since the height difference should be less than 1.
 * The possible heights of left anf right tree are as follows:
 * (h - 1) * (h - 2)
 * (h - 2) * (h - 1)
 * (h - 1) * (h - 1)
 */
public class BalancedHeightTrees {

    static long countBT(int h) {
        long[] dp = new long[h + 1];
        long mod = 1000000007;

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= h; i++) {
            dp[i] = (dp[i - 1] * ((2 * dp[i - 2]) % mod + dp[i - 1]) % mod) % mod;
        }
        return dp[h];
    }
}
