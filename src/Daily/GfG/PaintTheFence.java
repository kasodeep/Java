package Daily.GfG;

import java.util.Arrays;

public class PaintTheFence {

    public static long countWays(int n, int k) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, 0);

        dp[1] = k;
        long same, diff = k;

        for (int i = 2; i <= n; i++) {
            // Updating the value of same to the previous value of diff.
            same = diff;
            diff = dp[i - 1] * (k - 1) % 1000000007;
            dp[i] = (same + diff) % 1000000007;
        }

        return dp[n];
    }

    public static void main(String[] args) {

    }
}
