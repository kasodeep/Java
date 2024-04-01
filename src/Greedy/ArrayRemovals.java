package Greedy;

import java.util.Arrays;

public class ArrayRemovals {

    static int removals(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int i = 0, j = 0, mx = 0;

        while (j < n) {
            if (arr[j] - arr[i] <= k) j++;
            else i++;
            mx = Math.max(mx, j - i);
        }
        return n - mx;
    }
}
