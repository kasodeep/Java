package Array;

import java.util.Arrays;

public class MinimizeHeightsTwo {

    public static int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int maxi, mini, res = arr[n - 1] - arr[0];

        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - k < 0)
                continue;

            mini = Math.min(arr[0] + k, arr[i + 1] - k);
            maxi = Math.max(arr[i] + k, arr[n - 1] - k);
            res = Math.min(res, maxi - mini);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 10};
        System.out.println(getMinDiff(arr, arr.length, 2));
    }
}
