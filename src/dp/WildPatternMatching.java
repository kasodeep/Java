package dp;

public class WildPatternMatching {

    public static boolean match(String pattern, String str) {
        int m = str.length();
        int n = pattern.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i <= m; i++) dp[i][0] = false;

        for (int j = 1; j <= n; j++) {
            if (pattern.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if ((pattern.charAt(j - 1) == str.charAt(i - 1)) || (pattern.charAt(j - 1) == '?')) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

    }
}
