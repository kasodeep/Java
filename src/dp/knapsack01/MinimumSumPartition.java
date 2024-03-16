package dp.knapsack01;

/**
 * Find all the subsets with minimum sum difference.
 */
public class MinimumSumPartition {

    public static int minDifference(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) sum += arr[i];

        boolean[][] t = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) t[i][0] = true;
        for (int i = 1; i <= sum; i++) t[0][i] = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] || t[i - 1][j - arr[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            if (t[n][i]) minDiff = Math.min(minDiff, sum - 2 * i);
        }
        return minDiff;
    }
}
