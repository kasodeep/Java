package Sorting;

/**
 * Time Complexity: Worst -O(N^2), Best & Average - O(NlogN), Auxiliary Space: O(1).
 * It is "UnStable Sort" as it does change the order of the duplicate items.
 * It is also "In Place".
 */
public class QuickSort {

    // Utility function to swap to values of array
    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // Partition Function which creates pivotIdx and also segregates the elements.
    static int partition(int[] arr, int st, int end) {

        // Taking 1st Element as pivot
        int pivot = arr[st];
        int cnt = 0;

        // Counting the Number of Elements less than pivot
        for (int i = st + 1; i <= end; i++) {
            if (arr[i] < pivot)
                cnt++;
        }
        int pivotIdx = st + cnt;
        swap(arr, st, pivotIdx);
        int i = st, j = end;

        // Arranging the elements
        while (i < pivotIdx && j > pivotIdx) {
            while (arr[i] <= pivot)
                i++;
            while (arr[j] < pivot)
                j--;
            if (i < pivotIdx && j > pivotIdx) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return pivotIdx;
    }

    // First Self-Work and Recursive Function.
    public static void quickSort(int[] arr, int st, int end) {
        if (st >= end)
            return;

        // Getting Partition Index.
        int pi = partition(arr, st, end);
        quickSort(arr, st, pi - 1);
        quickSort(arr, pi + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 1, 5, 4};
        quickSort(arr, 0, arr.length - 1);

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
