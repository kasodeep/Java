package Searching;

import java.util.Arrays;

public class AggressiveCows {

    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        if (k > n) return -1;
        int st = 0, end = (int) 1e9, ans = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (isPossible(stalls, k, mid)) {
                ans = mid;
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    static boolean isPossible(int[] a, int k, int dist) {
        int cowsPlaces = 1;
        int lastCow = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] - lastCow >= dist) {
                cowsPlaces++;
                lastCow = a[i];
            }
        }
        return cowsPlaces >= k;
    }
}
