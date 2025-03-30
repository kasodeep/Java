package dp.commonsubsequence;

public class LongestPalindromicSubstringConcateTwo {

    static int ans;

    public int longestPalindrome(String s, String t) {
        ans = 0;
        int[] dps = lpsStart(s), dpt = lpsEnd(t);
        for (int i : dps) {
            ans = Math.max(ans, i);
        }
        for (int i : dpt) {
            ans = Math.max(ans, i);
        }
        Integer[][] dp = new Integer[s.length()][t.length()];
        find(dp, dps, dpt, s, t, s.length() - 1, 0);
        return ans;
    }

    static int find(Integer[][] dp, int[] dps, int[] dpt, String s, String t, int i, int j) {
        if (i < 0 && j >= t.length()) {
            return 0;
        }
        if (i < 0) {
            return 0;
        }
        if (j >= t.length()) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int res = 0;
        if (s.charAt(i) == t.charAt(j)) {
            res = 2 + find(dp, dps, dpt, s, t, i - 1, j + 1);
        }
        ans = Math.max(ans, res + (j > 0 ? dpt[j - 1] : 0));
        ans = Math.max(ans, res + (i < s.length() - 1 ? dps[i + 1] : 0));
        find(dp, dps, dpt, s, t, i - 1, j);
        find(dp, dps, dpt, s, t, i, j + 1);
        return dp[i][j] = res;
    }

    static int[] lpsStart(String s) {
        int[] res = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            res[i] = Math.max(res[i], 1);
            int len = expand(s, i, i);
            res[i - len] = Math.max(res[i - len], len * 2 + 1);

            len = expand(s, i, i + 1);
            if (len >= 0) {
                res[i - len] = Math.max(res[i - len], len * 2 + 2);
            }
        }
        return res;
    }

    static int expand(String s, int l, int r) {
        int res = 0;
        while (r < s.length() && l >= 0 && s.charAt(l) == s.charAt(r)) {
            res++;
            r++;
            l--;
        }
        return res - 1;
    }

    static int[] lpsEnd(String s) {
        int[] res = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            res[i] = Math.max(res[i], 1);
            int len = expand(s, i, i);
            res[i + len] = Math.max(res[i + len], len * 2 + 1);

            len = expand(s, i - 1, i);
            if (len >= 0) {
                res[i + len] = Math.max(res[i + len], len * 2 + 2);
            }
        }
        return res;
    }
}
