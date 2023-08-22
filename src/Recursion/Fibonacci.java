package Recursion;

public class Fibonacci {

    // Time Complexity - O(2^N), Auxiliary Space - O(2^N)
    static int fib(int n) {
        // Base Case
        if (n == 0 || n == 1)
            return n;

        // Self-Work & Assumption
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
