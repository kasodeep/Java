package Greedy;

import java.util.Arrays;

public class MaxSumKNegations {

    public static long maximizeSum(long[] a, int n, int k) {
        long sum = 0;
        long min = Long.MAX_VALUE;

        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            if (a[i] < 0 && k > 0) {
                a[i] = -a[i];
                k--;
            }

            sum += a[i];
            min = Math.min(Math.abs(a[i]), min);
        }

        if (k > 0 && k % 2 != 0) sum -= 2 * min;
        return sum;
    }
}
