package Array;

import java.util.HashMap;

public class PairsWithGivenSum {

    static int getPairsCount(int[] arr, int n, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(sum - arr[i])) {
                count += map.get(sum - arr[i]);
            }
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        return count;
    }

    // Time Complexity - O(n), Auxiliary Space - O(1)
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int n = arr.length;
        int sum = 6;
        System.out.println("Count of pairs is: " + getPairsCount(arr, n, sum));
    }
}
