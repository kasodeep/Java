package Sorting;

/**
 * Time Complexity: Worst & Average - O(N^2), Best - O(N), Auxiliary Space: O(1)
 * It is "Stable Sort" as it does not change the order of the duplicate items.
 * It is also "In Place".
 */
public class InsertionSort {

    static void insertionSort(int[] arr) {
        int n = arr.length;

        // Outer For Loop
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 5, 4, 6, 3, 2};
        insertionSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
