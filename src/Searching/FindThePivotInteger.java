package Searching;

public class FindThePivotInteger {

    public static int pivotInteger(int n) {
        int left = 1, right = n;
        int totalSum = n * (n + 1) / 2;

        while (left < right) {
            int mid = (left + right) / 2;
            if (mid * mid - totalSum < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left * left - totalSum == 0) return left;
        else return -1;
    }
}
