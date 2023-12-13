package Daily.GfG;

public class NoConsecutiveOnes {

    static long countStrings(int n) {
        final long MOD = 1000_000_007;

        // No of strings ending with 0 represented by a .
        long[] a = new long[n], b = new long[n];
        a[0] = b[0] = 1;

        for (int i = 1; i < n; i++) {
            a[i] = (a[i - 1] % MOD + b[i - 1] % MOD) % MOD;
            b[i] = a[i - 1] % MOD;
        }
        return (a[n - 1] % MOD + b[n - 1] % MOD) % MOD;
    }

    public static void main(String[] args) {

    }
}
