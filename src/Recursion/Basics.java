package Recursion;

/*
 ­1) A precondition that is used to stop this recursive call (Halting Condition).
 2) A function that is capable of calling itself ( recursive call).
 3) Call Stack : It is created during recursion calls and causes Stack Overflow Error.
 */

public class Basics {

    static void printNumbers(int n) {

        // Base Case
        if (n == 1) {
            System.out.println(1);
            return;
        }

        // Assumption
        printNumbers(n - 1);

        // Self-Work
        System.out.print(n + " ");
    }

    static void printNumbersReverse(int n) {

        // Base Case
        if (n == 1) {
            System.out.println(1);
            return;
        }

        // Self-Work
        System.out.print(n + " ");

        // Assumption
        printNumbers(n - 1);

    }

    public static void main(String[] args) {

    }
}
