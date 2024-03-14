package Array;

public class BinarySubArraySumGoal {

    /**
     * Finding sub-arrays with sum <= goal.
     */
    private int slidingWindowAtMost(int[] nums, int goal) {
        int start = 0, currentSum = 0, totalCount = 0;

        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];
            while (start <= end && currentSum > goal) {
                currentSum -= nums[start++];
            }
            totalCount += end - start + 1;
        }
        return totalCount;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindowAtMost(nums, goal) - slidingWindowAtMost(nums, goal - 1);
    }
}
