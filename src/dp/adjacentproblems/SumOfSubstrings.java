package dp.adjacentproblems;

public class SumOfSubstrings {

    public static long sumSubstrings(String s) {
        int mod = 1000000007;
        int n = s.length();

        long[] dp = new long[(int) n];
        dp[0] = s.charAt(0) - '0';

        long ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = ((dp[i - 1] * 10) % mod + ((long) (s.charAt(i) - '0') * (i + 1)) % mod) % mod;
            ans = (ans + dp[i]) % mod;
        }
        return ans;
    }
}
