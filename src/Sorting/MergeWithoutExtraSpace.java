package Sorting;

import java.util.Arrays;

public class MergeWithoutExtraSpace {

    public static void merge(long[] arr1, long[] arr2, int n, int m) {
        for (int i = n - 1, j = 0; i >= 0 && j < m; i--, j++) {
            if (arr1[i] > arr2[j]) {
                long temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            } else break;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
