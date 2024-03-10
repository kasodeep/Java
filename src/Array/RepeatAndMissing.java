package Array;

public class RepeatAndMissing {

    static int[] findTwoElement(int[] arr, int n) {
        int[] result = new int[2];

        long sum = 0, sumOfSquares = 0;
        for (int i = 0; i < n; ++i) {
            sum += arr[i];
            sumOfSquares += (long) arr[i] * arr[i];
        }

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSumOfSquares = (long) n * (n + 1) * (2L * n + 1) / 6;

        long diffSum = expectedSum - sum;
        long diffSumOfSquares = expectedSumOfSquares - sumOfSquares;

        int missing = (int) ((diffSumOfSquares - diffSum * diffSum) / (2 * diffSum));
        int duplicate = missing + (int) diffSum;
        result[0] = missing;
        result[1] = duplicate;
        return result;
    }
}
