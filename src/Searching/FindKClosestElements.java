package Searching;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - k;

        while (start < end) {
            int mid = (start + end) / 2;
            if (x - arr[mid] > arr[mid + k] - x) start = mid + 1;
            else end = mid;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = start; i < start + k; i++) result.add(arr[i]);
        return result;
    }

    static int[] printKClosest(int[] arr, int n, int k, int x) {
        int id1 = findCrossOver(arr, 0, n - 1, x);
        int id2 = id1 + 1;

        if (arr[id1] == x) id1--;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            if (id1 >= 0 && id2 < n) {
                int val1 = x - arr[id1], val2 = arr[id2] - x;
                if (val1 < val2) {
                    ans[i] = arr[id1];
                    id1--;
                } else {
                    ans[i] = arr[id2];
                    id2++;
                }
            } else if (id1 >= 0) {
                ans[i] = arr[id1];
                id1--;
            } else {
                ans[i] = arr[id2];
                id2++;
            }
        }
        return ans;
    }

    private static int findCrossOver(int[] arr, int low, int high, int x) {
        if (arr[high] <= x) return high;
        if (arr[low] > x) return low;

        int mid = (low + high) / 2;
        if (arr[mid] <= x && arr[mid + 1] > x) {
            return mid;
        } else if (arr[mid] < x) {
            return findCrossOver(arr, mid + 1, high, x);
        }
        return findCrossOver(arr, low, mid - 1, x);
    }
}
