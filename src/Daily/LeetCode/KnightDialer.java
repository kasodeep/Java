package Daily.LeetCode;

public class KnightDialer {

    static int[][] memo;
    static int n;
    static int MOD = (int) 1e9 + 7;
    static int[][] jumps = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};

    public static int dp(int remain, int square) {
        if (remain == 0) return 1;
        if (memo[remain][square] != 0) return memo[remain][square];

        int ans = 0;
        for (int nextSquare : jumps[square]) {
            ans = (ans + dp(remain - 1, nextSquare)) % MOD;
        }

        memo[remain][square] = ans;
        return ans;
    }

    public static int knightDialer(int n) {
        memo = new int[n + 1][10];
        int ans = 0;

        for (int square = 0; square < 10; square++) {
            ans = (ans + dp(n - 1, square)) % MOD;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
