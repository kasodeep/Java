package Recursion;

public class Factorial {

    // Time Complexity - O(n), Auxiliary Space - O(n)
    static int factorial(int n) {
        // Base Case
        if (n == 0 || n == 1)
            return 1;

        // Self-Work and Assumption
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
