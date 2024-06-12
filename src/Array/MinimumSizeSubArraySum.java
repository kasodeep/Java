package Array;

public class MinimumSizeSubArraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int low = 0;
        int ans = Integer.MAX_VALUE;

        for (int high = 0; high < nums.length; high++) {
            sum += nums[high];

            while (sum >= target && low <= high) {
                sum -= nums[low++];
            }
            ans = Math.min(ans, high - low + 1);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
