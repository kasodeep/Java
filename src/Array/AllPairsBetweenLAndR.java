package Array;

import java.util.Arrays;

/**
 * V.IMP Question, Good Concept!
 * */
public class AllPairsBetweenLAndR {

    static int lowerBound(int[] a, int low, int high, int element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (element > a[middle]) low = middle + 1;
            else high = middle;
        }
        return low;
    }

    static int upperBound(int[] a, int low, int high, int element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (a[middle] > element) high = middle;
            else low = middle + 1;
        }
        return low;
    }

    // Function to count pairs whose sum lies over the range [L, R]
    static int countPairSum(int[] arr, int L, int R, int N) {
        Arrays.sort(arr);
        int right = N - 1, count = 0;

        while (right > 0) {
            // Starting index of element whose sum with arr[right] >= L.
            int it1 = lowerBound(arr, 0, N, L - arr[right]);
            it1++;
            int start = it1 - arr[0];

            // Ending index of element whose sum with arr[right] <= R.
            int it2 = upperBound(arr, 0, N, R - arr[right]);
            int end = it2 - arr[0];
            end = Math.min(end, right - 1);

            // Add the count of elements to the variable count.
            if (end - start >= 0) count += (end - start + 1);
            right--;
        }
        return count;
    }
}
