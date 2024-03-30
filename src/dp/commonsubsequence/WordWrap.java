package dp.commonsubsequence;

import java.util.Arrays;

public class WordWrap {

    public static int solveWordWrap(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(0, nums, k, dp);
    }

    public static int solve(int i, int[] nums, int k, int[] dp) {
        if (i == nums.length) return 0;
        if (dp[i] != -1) return dp[i];

        int temp = 0;
        int ans = Integer.MAX_VALUE;

        for (int ind = i; ind < nums.length; ind++) {
            if (temp + nums[ind] <= k) {
                temp += nums[ind];
                if (ind == nums.length - 1) ans = Math.min(ans, solve(ind + 1, nums, k, dp));
                else ans = Math.min(ans, (int) Math.pow((k - temp), 2) + solve(ind + 1, nums, k, dp));

                // For spaces in-between.
                temp++;
            } else {
                break;
            }
        }
        return dp[i] = ans;
    }
}
