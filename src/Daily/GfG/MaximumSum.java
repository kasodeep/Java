package Daily.GfG;

public class MaximumSum {

    public static int maxSumIS(int[] arr, int n) {
        int[] dp = new int[n];

        int i = 0;
        while (i < n) {
            dp[i] = arr[i];
            i++;
        }

        int maxValue = 0;
        for (i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            if (maxValue < dp[i]) maxValue = dp[i];
        }
        return maxValue;
    }

    public static void main(String[] args) {

    }
}
