package dp;

public class nPr {

    public static int npr(int n, int k) {
        long p = 1;
        long mod = 1000000007;

        for (int i = 0; i < k; i++) p = ((p % mod) * ((n - i) % mod)) % mod;
        return (int) p;
    }
}
