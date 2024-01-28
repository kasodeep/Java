package Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("ALL")
public class MaxMinDifference {

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum = 0;
        Deque<Integer> q = new ArrayDeque<>();

        q.add(-1);
        for (int i = 0; i <= n; i++) {
            while (q.peekLast() != -1 && (i == n || nums[q.peekLast()] <= nums[i])) {
                int cur = q.removeLast();
                int left = q.peekLast();
                int right = i;
                sum += 1L * (cur - left) * (right - cur) * nums[cur];
            }
            q.add(i);
        }

        q.clear();
        q.add(-1);
        for (int i = 0; i <= n; i++) {
            while (q.peekLast() != -1 && (i == n || nums[q.peekLast()] >= nums[i])) {
                int cur = q.removeLast();
                int left = q.peekLast();
                int right = i;
                sum -= 1L * (cur - left) * (right - cur) * nums[cur];
            }
            q.add(i);
        }
        return sum;
    }
}
