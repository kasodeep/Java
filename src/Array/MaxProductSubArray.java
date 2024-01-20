package Array;

public class MaxProductSubArray {

    public static int maxProduct(int[] arr) {
        int n = arr.length;
        int maxEndingHere = arr[0];
        int minEndingHere = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            int temp = Math.max(Math.max(arr[i], arr[i] * maxEndingHere), arr[i] * minEndingHere);
            minEndingHere = Math.min(Math.min(arr[i], arr[i] * maxEndingHere), arr[i] * minEndingHere);
            maxEndingHere = temp;
            max = Math.max(max, maxEndingHere);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, -1};
        System.out.println(maxProduct(arr));
    }
}
