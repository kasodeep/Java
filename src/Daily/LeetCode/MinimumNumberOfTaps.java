package Daily.LeetCode;

public class MinimumNumberOfTaps {

    public static int minTaps(int n, int[] ranges) {
        int[] arr = new int[n + 1];

        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int left = Math.max(0, i - ranges[i]);
            arr[left] = Math.max(arr[left], i + ranges[i]);
        }

        int end = 0, far_can_reach = 0, cnt = 0;
        for (int i = 0; i <= n; i++) {
            if (i > end) {
                if (far_can_reach <= end) return -1;
                end = far_can_reach;
                cnt++;
            }
            far_can_reach = Math.max(far_can_reach, arr[i]);
        }
        return cnt + (end < n ? 1 : 0);
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ranges = {3, 4, 1, 1, 0, 0};
        System.out.println(minTaps(n, ranges));
    }
}
