package dp;

public class ExpressionMatching {

    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        Boolean[][] M = new Boolean[m + 1][n];
        return dfs(s, p, 0, 0, m, n, M);
    }

    private static boolean dfs(String s, String p, int i, int j, int m, int n, Boolean[][] M) {
        if (j == n)
            return i == m;
        if (M[i][j] != null)
            return M[i][j];

        char c2 = p.charAt(j);
        if (j < n - 1 && p.charAt(j + 1) == '*')
            return M[i][j] = dfs(s, p, i, j + 2, m, n, M) ||
                    i < m && match(s.charAt(i), c2) && dfs(s, p, i + 1, j, m, n, M);

        return M[i][j] = i < m && match(s.charAt(i), c2) && dfs(s, p, i + 1, j + 1, m, n, M);
    }

    private static boolean match(char c1, char c2) {
        if (c2 == '.') return true;
        return c1 == c2;
    }
}
