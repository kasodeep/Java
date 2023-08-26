package Sorting;

/**
 * Time Complexity: Worst & Average - O(N^2), Best - O(N), Auxiliary Space: O(1)
 * It is "Stable Sort" as it does not change the order of the duplicate items.
 * It is also "In Place" Algorithm.
 */
public class BubbleSort {

    static void bubbleSort(int[] arr) {
        int n = arr.length;

        // Outer For Loop
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;

            // Inner For Loop
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            // Optimizing the Approach
            if (!flag)
                return;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 4, 5, 1, 2};
        bubbleSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
