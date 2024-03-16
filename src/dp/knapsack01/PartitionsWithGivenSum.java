package dp.knapsack01;

/**
 * Can we partition such that the two arrays have difference equal to d
 */
public class PartitionsWithGivenSum {

    static int mod = 1000000007;

    public static int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) sum += arr[i];
        sum += d;

        if (sum % 2 != 0) return 0;
        sum /= 2;

        int[][] t = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) t[i][0] = 1;
        for (int i = 1; i <= sum; i++) t[0][i] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
                t[i][j] %= mod;
            }
        }

        return t[n][sum];
    }
}
