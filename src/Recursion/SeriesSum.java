package Recursion;

public class SeriesSum {

    static int seriesSum(int n) {

        // Base Case
        if (n == 0)
            return 0;

        // Self-Work and Recursion
        if (n % 2 == 0) {
            return seriesSum(n - 1) - n;
        } else {
            return seriesSum(n - 1) + n;
        }
    }

    public static void main(String[] args) {

    }
}
