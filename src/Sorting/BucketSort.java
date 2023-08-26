package Sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Time Complexity: Worst & Average -O(N+K), Best - O(N), Auxiliary Space: O(N+K)
 * It is "Stable Sort" as it does not change the order of the duplicate items.
 * It is also "In Place".
 */
public class BucketSort {

    static void bucketSort(float[] arr) {
        int n = arr.length;

        // Buckets
        ArrayList<ArrayList<Float>> buckets = new ArrayList<>(n);

        // Create empty buckets
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        // Add elements into our buckets
        for (float num : arr) {
            int bucketIndex = (int) num * n;
            buckets.get(bucketIndex).add(num);
        }

        // Sort each bucket individually
        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Merge all buckets to get final sorted array
        int index = 0;
        for (ArrayList<Float> currBucket : buckets) {
            for (Float num : currBucket) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = {0.5f, 0.4f, 0.3f, 0.2f, 0.1f};
        bucketSort(arr);

        for (float val : arr) {
            System.out.print(val + " ");
        }
    }
}
