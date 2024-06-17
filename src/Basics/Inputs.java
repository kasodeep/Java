package Basics;

import java.util.Scanner;

// There is an InputMismatchException in Scanner Class.
public class Inputs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your Name:");
        String name = sc.nextLine();
        System.out.println("Your Name is " + name);

        System.out.println("Enter Your Character:");
        char ch = sc.next().charAt(0);
        System.out.println("Your Character is " + ch);

        while (sc.hasNextLine()) {
            String a = sc.next();
            String b = sc.next();
            System.out.println(a + b);
        }

        sc.close();
    }
}
