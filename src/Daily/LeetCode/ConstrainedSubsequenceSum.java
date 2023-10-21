package Daily.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstrainedSubsequenceSum {

    public static int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && i - queue.peek() > k) {
                queue.poll();
            }

            dp[i] = (!queue.isEmpty() ? dp[queue.peek()] : 0) + nums[i];
            while (!queue.isEmpty() && dp[queue.peekLast()] < dp[i]) {
                queue.pollLast();
            }

            if (dp[i] > 0) {
                queue.offer(i);
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int num : dp) ans = Math.max(ans, num);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10, -2, -10, -5, 20};
        int k = 2;
        System.out.println(constrainedSubsetSum(nums, k));
    }
}
