package Array;

public class NextPermutation {

    public static void nextPermutation(int[] arr) {
        int n = arr.length, i, j;
        for (i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
        }

        if (i < 0) {
            reverse(arr, 0, arr.length - 1);
        } else {
            // Find the rightmost successor to the pivot element.
            for (j = n - 1; j > i; j--) {
                if (arr[j] > arr[i]) {
                    break;
                }
            }

            // Swap the pivot and the successor.
            swap(arr, i, j);
            reverse(arr, i + 1, arr.length - 1);
        }
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

    }
}
