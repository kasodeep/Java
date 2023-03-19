package Recursion;

public class EuclideanAlgo {

    /**
     * 
     * @param a - It is the first number
     * @param b - It is the second number
     * @return - It returns the gcd of {a} and {b}
     */
    public static int gcd(int a, int b) {

        // Base Case
        if (a == 0)
            return b;

        // Self-Work
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        System.out.println(gcd(7, 5));
    }
}
