package dp.commonsubsequence;

import java.util.Arrays;

public class LongestSubsequenceDiffOne {

    public static int longestSubsequence(int n, int[] arr) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxValue = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(arr[j] - arr[i]) == 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (maxValue < dp[i]) maxValue = dp[i];
        }
        return maxValue;
    }
}
