package Daily.LeetCode;

import java.util.ArrayList;
import java.util.Scanner;

public class TomJerryBase10 {

    static final long mod = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> v = new ArrayList<>();
        for (int i = 0; i < n; i++) v.add(sc.nextInt());

        int[][] dp = new int[n][10];
        dp[0][v.get(0)] = 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i + 1][(j + v.get(i + 1)) % 10] += dp[i][j] % mod;
                dp[i + 1][(j + v.get(i + 1)) % 10] %= mod;
                dp[i + 1][(j * v.get(i + 1)) % 10] += dp[i][j] % mod;
                dp[i + 1][(j * v.get(i + 1)) % 10] %= mod;
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(dp[n - 1][i]);
        }
    }
}
