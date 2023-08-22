package Recursion;

public class PlusMinusFive {

    static void printPattern(int n, int m, boolean flag) {
        System.out.print(m + " ");

        if (!flag && n == m)
            return;

        if (flag) {
            printPattern(n, m - 5, m - 5 > 0);
        } else
            printPattern(n, m + 5, false);
    }

    public static void main(String[] args) {
        printPattern(16, 16, true);
    }
}
