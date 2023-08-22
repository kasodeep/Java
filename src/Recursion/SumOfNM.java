package Recursion;

public class SumOfNM {

    public static int rec(int n, int m) {
        // Base Case
        if (m == 1)
            return sumOfN(n);

        // Self-Work
        int sum = rec(n, m - 1);
        return sumOfN(sum);
    }

    public static int sumOfN(int n) {
        // Base Case
        if (n == 1) {
            return 1;
        }

        // Self-Work
        return n + sumOfN(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(rec(3, 2));
    }
}
