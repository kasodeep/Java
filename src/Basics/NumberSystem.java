package Basics;

import java.util.Scanner;

public class NumberSystem {

    public static int decimalToBinary(int n) {
        int binarynum = 0;
        int power = 1;

        while (n != 0) {
            int rem = n % 2;
            binarynum += rem * power;
            power *= 10;
            n /= 2;
        }
        return binarynum;
    }

    public static int binaryToDecimal(int x) {
        int decimalnum = 0;
        int power = 1;

        while (x != 0) {
            int rem = x % 10;
            decimalnum += rem * power;
            power *= 2;
            x /= 10;
        }
        return decimalnum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the decimal number: ");
        int n = sc.nextInt();
        System.out.println(decimalToBinary(n));

        System.out.println("Enter the binary number: ");
        int x = sc.nextInt();
        System.out.print(binaryToDecimal(x));

        sc.close();
    }
}
