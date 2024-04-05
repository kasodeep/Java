package dp.commonsubsequence;

import java.util.Arrays;

public class MakeIncreasingArray {

    public int min_operations(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] - nums[j] >= i - j) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxOps = Arrays.stream(dp).max().getAsInt();
        return n - maxOps;
    }
}
