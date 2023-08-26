package Sorting;

public class PositiveNegative {

    public static void main(String[] args) {
        int[] arr = {19, -20, 7, -4, -13, 11, -5, 3};
        int n = arr.length;

        partition(arr, 0, n - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void partition(int[] arr, int st, int end) {
        int pIndex = st;
        for (int j = st; j <= end; j++) {
            if (arr[j] < 0) {
                int temp = arr[j];
                arr[j] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
    }
}
