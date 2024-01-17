package Sorting;

import java.util.Arrays;

public class TripletSumLessThanK {

    static long countTriplets(long[] arr, int n, int sum) {
        Arrays.sort(arr);
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0 && arr[i] == arr[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                long temp = arr[i] + arr[j] + arr[k];
                if (temp < sum) {
                    count += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }
}
