package Searching;

public class AllocateBooks {

    public static int findPages(int[] arr, int n, int m) {
        long sum = 0;
        long max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        if (m > n) return -1;
        long start = max, end = sum, ans = Integer.MAX_VALUE;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isValid(arr, mid, m)) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int) ans;
    }

    public static boolean isValid(int[] arr, long requiredSum, int m) {
        long sum = 0;
        int count = 1;
        for (int integer : arr) {
            if (sum + integer <= requiredSum) {
                sum += integer;
            } else {
                sum = integer;
                count++;
            }
        }
        return count <= m;
    }
}
