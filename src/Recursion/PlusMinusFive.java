package Recursion;

public class PlusMinusFive {

    static void printPattern(int n, int m, boolean flag) {

        System.out.print(m + " ");
        // If we are moving back towards n and we have reached there, then we done
        if (flag == false && n == m)
            return;

        // If we are moving towards 0 or negative.
        if (flag) {
            // If m is greater, then 5, recur with true flag
            if (m - 5 > 0)
                printPattern(n, m - 5, true);

            else // recur with false flag
                printPattern(n, m - 5, false);
        } else // If flag is false.
            printPattern(n, m + 5, false);
    }

    public static void main(String[] args) {
        printPattern(16, 16, true);
    }
}
