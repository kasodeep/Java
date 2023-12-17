package Daily.GfG;

public class MaxSumWithoutAdjacent {

    public static int findMaxSum(int[] arr, int n) {
        if (n == 0) return 0;

        int value1 = arr[0];
        if (n == 1) return value1;

        int value2 = Math.max(arr[0], arr[1]);
        if (n == 2) return value2;

        int maxSum = 0;
        for (int i = 2; i < n; i++) {
            maxSum = Math.max(arr[i] + value1, value2);
            value1 = value2;
            value2 = maxSum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 10};
        System.out.println(findMaxSum(arr, arr.length));
    }
}
