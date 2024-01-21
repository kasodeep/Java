package Array;

public class ThreeWayPartition {

    public static void threeWayPartition(int[] arr, int a, int b) {
        int n = arr.length;
        int low = 0, high = n - 1;

        for (int i = 0; i <= high; ) {
            if (arr[i] < a) swap(arr, i++, low++);
            else if (arr[i] >= a && arr[i] <= b) i++;
            else if (arr[i] > b) swap(arr, i, high--);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
