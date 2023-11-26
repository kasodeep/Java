package Daily.LeetCode;

public class SumOfAbsoluteDifference {

    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + nums[i];

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int leftSum = prefix[i] - nums[i];
            int rightSum = prefix[n - 1] - prefix[i];

            int leftTotal = i * nums[i] - leftSum;
            int rightTotal = rightSum - (n - 1 - i) * nums[i];
            ans[i] = leftTotal + rightTotal;
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
