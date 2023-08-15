package Array;

import java.util.Arrays;

public class MinimumPlatforms {

    /**
     * @param arr - It represents the arrival time for the trains.
     * @param dep - It represents the departure time for the trains.
     * @return - It represents the minimum number of platforms a station must
     * possess.
     */
    static int findTotalPlatforms(int[] arr, int[] dep) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;
        int plat_needed = 1, result = 1, i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            } else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }

            if (plat_needed > result)
                result = plat_needed;
        }
        return result;
    }

    // Time Complexity - O(n* log(n)), Auxiliary Space - O(1)
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findTotalPlatforms(arr, dep));
    }
}
