package Sorting;

/**
 * 1) Non-Comparison
 * 2) This sorting Technique is used when Whe Range of input is limited.
 * Time Complexity: Worst & Average -O(N+K), Best - O(N), Auxiliary Space: O(N+K)
 * k is the time required to find the maximum number.
 * It is "Stable Sort" as it does not change the order of the duplicate items.
 * It is also "In Place".
 */
public class CountSort {

    // Utility Function to Display Array
    static void display(int[] a) {
        for (int val : a) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Finding the Max Element.
    static int findMax(int[] arr) {
        int mx = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > mx) mx = num;
        }
        return mx;
    }

    // Basic Count Sort Function
    static void basicCountSort(int[] arr) {
        int max = findMax(arr);

        // Frequency Array.
        int[] count = new int[max + 1];
        for (int value : arr) {
            count[value]++;
        }

        // Adding Elements to Array.
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k++] = i;
            }
        }
    }

    // Advanced Count Sort.
    static void countSort(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];
        int max = findMax(arr);

        // Frequency Array
        int[] count = new int[max + 1];
        for (int num : arr) {
            count[num]++;
        }

        // Make Prefix sum array of Frequency array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element in the original array and put it in output, To Make Stable.
        for (int i = n - 1; i >= 0; i--) {
            int idx = count[arr[i]] - 1;
            output[idx] = arr[i];
            count[arr[i]]--;
        }

        // Copy all elements of output to array.
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 2, 5};
        countSort(arr);
        basicCountSort(arr);
        display(arr);
    }
}
