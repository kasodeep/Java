package Array;

public class Reverse {

    /**
     * @param arr - It is the array which must be reversed.
     */
    static void reverseArray(int[] arr) {
        int temp, start = 0, end = arr.length - 1;

        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
