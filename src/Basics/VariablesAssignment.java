package Basics;

public class VariablesAssignment {

    public static void main(String[] args) {

        // Q1) To print product of two numbers.
        int x = 10;
        int y = 14;
        System.out.println(x * y);

        // Q2) To print ASCII value of 'U'.
        int ascii = 'U';
        System.out.println(ascii);

        // Q3) To print area of rectangle.
        int length = 25;
        int breadth = 17;
        System.out.println("The length is: " + length);
        System.out.println("The breadth is: " + breadth);
        System.out.println("The area is: " + length * breadth);

        // Q4) To calculate cube of a number.
        int a = 4;
        System.out.println("The cube of " + a + " is: " + a * a * a);

        // Q5) To swap values of two variables.
        int m = 2;
        int n = 3;
        System.out.println("The first number before swap is :" + m);
        System.out.println("The second number before swap is : " + n);
        int temp = m;
        m = n;
        n = temp;
        System.out.println("The first number after swap is :" + m);
        System.out.println("The second number after swap is : " + n);
    }
}
