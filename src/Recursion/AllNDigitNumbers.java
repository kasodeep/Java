package Recursion;

import java.util.Scanner;

public class AllNDigitNumbers {

    /* The digits of all numbers must be in increasing order. */
    public static void printNDigitNumber(int start, String out, int n) {
        if (n == 0) {
            System.out.print(out + " ");
            return;
        }

        for (int i = start; i <= 9; i++) {
            String str = out + i;
            printNDigitNumber(i + 1, str, n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");

        int n = sc.nextInt();
        printNDigitNumber(0, " ", n);
    }
}
