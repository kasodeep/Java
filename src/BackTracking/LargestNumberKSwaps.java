package BackTracking;

import java.util.Arrays;

public class LargestNumberKSwaps {

    public static String findMaximumNum(String str, int k) {
        char[] arr = str.toCharArray();
        char[] max = Arrays.copyOf(arr, arr.length);

        permute(arr, k, max, 0);
        return new String(max);
    }

    static void permute(char[] arr, int k, char[] max, int idx) {
        if (k == 0 || arr.length - 1 == idx) return;

        for (int i = idx; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    if (compare(arr, max)) {
                        System.arraycopy(arr, 0, max, 0, arr.length);
                    }

                    permute(arr, k - 1, max, i);
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static boolean compare(char[] arr1, char[] arr2) {
        String num1 = new String(arr1);
        String num2 = new String(arr2);
        return num1.compareTo(num2) > 0;
    }
}
