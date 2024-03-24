package dp.commonsubsequence;

public class MaxSumIncreasingSubsequence {

    public int maxSumIS(int[] arr, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = arr[i];

        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }

            if (maxValue < dp[i]) maxValue = dp[i];
        }
        return maxValue;
    }
}
