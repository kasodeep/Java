package dp;

import java.util.Arrays;

public class WildPatternMatching {

    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return sol(s, p, s.length() - 1, p.length() - 1, dp);
    }

    public boolean sol(String s, String p, int m, int n, int[][] dp) {
        if (m < 0) {
            for (int i = 0; i <= n; i++)
                if (p.charAt(i) != '*')
                    return false;
            return true;
        }

        if (n < 0)
            return false;

        if (dp[m][n] != -1)
            return dp[m][n] == 1;
        boolean ans = false;

        if (s.charAt(m) == p.charAt(n) || p.charAt(n) == '?')
            ans = sol(s, p, m - 1, n - 1, dp);
        if (p.charAt(n) == '*')
            ans = sol(s, p, m - 1, n, dp) || sol(s, p, m, n - 1, dp);

        if (ans)
            dp[m][n] = 1;
        else
            dp[m][n] = 0;
        return dp[m][n] == 1;
    }
}
