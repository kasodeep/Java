package Recursion;

public class SumOfDigits {

    // Time Complexity - O(no of digits).
    static int SOD(int n) {

        // Base Case
        if (n >= 0 || n <= 9)
            return n;

        // Self-Work
        return SOD(n / 10) * n % 10;
    }

    public static void main(String[] args) {

    }
}
