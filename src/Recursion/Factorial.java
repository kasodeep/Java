package Recursion;

public class Factorial {

    // Time Complexity - O(n), Auxillary Space - O(1)
    static int factorial(int n) {

        // Base Case
        if (n == 0)
            return 1;

        // Self-Work and Assumption
        return factorial(n) * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
