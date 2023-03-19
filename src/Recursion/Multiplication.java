package Recursion;

public class Multiplication {

    /**
     * 
     * @param a - It is the first number to be multiplied
     * @param b - It is the second number to be multiplied
     * @return - It returns the prouct of {a} and {b}
     */
    static int multiply(int a, int b) {

        // Swapping
        if (b > a) {
            int t = a;
            a = b;
            b = t;
        }

        // Base Case
        if (b == 1) {
            return a;
        }

        // Self-Work
        return multiply(a, b - 1) + a;
    }

    public static void main(String[] args) {
        int x = 2;
        int y = 3;
        System.out.println(multiply(x, y));
    }
}
