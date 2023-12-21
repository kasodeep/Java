package Daily.LeetCode;

import java.util.Arrays;

public class WidestVerticalArea {

    public static int maxWidthOfVerticalArea(int[][] points) {
        int max = 0;
        int n = points.length;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = points[i][0];

        Arrays.sort(arr);
        for (int j = 0; j < n - 1; j++) max = Math.max(max, arr[j + 1] - arr[j]);
        return max;
    }

    public static void main(String[] args) {

    }
}
