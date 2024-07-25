package Sorting;

/**
 * Time Complexity: Worst & Average - O(NlogN), Best - O(NlogN), Auxiliary Space: O(N)
 * It is "Stable Sort" as it does not change the order of the duplicate items.
 * It is not an "In Place".
 * T(n) = 2T(n/2) + O(n)
 */
public class MergeSort {

    // Merging to sorted arrays
    static void merge(int[] arr, int st, int mid, int end) {

        // Creating left and Right Array.
        int n1 = mid - st + 1;
        int n2 = end - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];
        int i, j, k;

        for (i = 0; i < n1; i++)
            left[i] = arr[st + i];
        for (j = 0; j < n2; j++)
            right[j] = arr[mid + j + 1];

        // Arranging the values in original array.
        i = j = 0;
        k = st;
        while (i < n1 && j < n2) {
            if (left[i] < right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        while (i < n1)
            arr[k++] = left[i++];
        while (j < n2)
            arr[k++] = left[j++];
    }

    // Divide and Conquer Technique is Used - Recursive Function
    static void mergeSort(int[] arr, int st, int end) {
        if (st >= end)
            return;

        int mid = st + (end - st) / 2;
        mergeSort(arr, st, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, st, mid, end);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        mergeSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
