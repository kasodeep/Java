package Recursion;

public class SumOfDigits {

    // Time Complexity - O(no of digits).
    public static int sumOfDigits(int n) {
        // Base Case
        if (n == 0)
            return 0;

        // Self-Work
        return sumOfDigits(n / 10) + n % 10;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(1643));
    }
}
