package Array;

public class SegregateEvenOdd {

    public static void segregateElements(int[] arr, int n) {
        int[] temp = new int[n];
        int pos = 0;
        int neg = n - 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                temp[neg] = arr[i];
                neg--;
            } else {
                temp[pos] = arr[i];
                pos++;
            }
        }

        int right = n - 1;
        for (int i = 0; i < n; i++) {
            if (temp[i] < 0) {
                arr[right] = temp[i];
                right--;
            } else {
                arr[i] = temp[i];
            }
        }
    }
}
