package dp;

public class PaintingTheFence {

    long mod = 1000000000 + 7;

    static long countWays(int n, int k) {
        if (n == 1) return k;

        long mod = (long) 1e9 + 7, same = 0, diff = k;

        for (int i = 2; i <= n; i++) {
            long prev = same;
            same = diff;
            diff = ((prev + same) * (k - 1)) % mod;
        }

        return (same + diff) % mod;
    }
}
