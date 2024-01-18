package Sorting;

import java.util.Arrays;

public class FindPairWithDifference {

    public static boolean findPair(int[] arr, int size, int n) {
        Arrays.sort(arr);
        int i = 0, j = 1;

        while (i < arr.length && j < arr.length) {
            if (arr[j] - arr[i] == n && j != i) return true;
            if (arr[j] - arr[i] > n) i++;
            else j++;
        }
        return false;
    }
}
