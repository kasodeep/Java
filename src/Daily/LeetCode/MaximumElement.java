package Daily.LeetCode;

import java.util.Arrays;

public class MaximumElement {

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int ans = 1;

        for (int i = 1; i < arr.length; i++) if (arr[i] >= ans + 1) ans++;
        return ans;
    }

    public static void main(String[] args) {

    }
}
