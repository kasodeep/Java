package Basics;

import java.util.Scanner;

/*
    * Bitwise Operators :
    * &(AND) , |(OR) , ^(XOR) , ~(1'Complements) 
    * <<(Left Shift) - Means times 2
    * >>(Right Shift) - Means divide 2
*/

public class Operators {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Swapping without Third Variable.
        System.out.println("Enter 1st number");
        int x = sc.nextInt();
        System.out.println("Enter 2nd number");
        int y = sc.nextInt();
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println(x);
        System.out.println(y);

        // Number of Flips to Change a to b. || Brian Kernighan algorithm.
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = a ^ b;
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        System.out.print(count);

        sc.close();
    }
}
