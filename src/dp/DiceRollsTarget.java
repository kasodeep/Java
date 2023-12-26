package dp;

public class DiceRollsTarget {

    public static int numRollsToTarget(int n, int k, int target) {
        long[][] dp = new long[n + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                long sum = 0;
                for (int x = 1; x < k + 1; x++) {
                    if (j - x >= 0) sum += dp[i - 1][j - x];
                }
                dp[i][j] = sum % 1000000007;
            }
        }
        return (int) (dp[n][target] % 1000000007);
    }

    public static void main(String[] args) {

    }
}
