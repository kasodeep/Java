package Recursion;

public class EuclideanAlgo {

    public static int gcd(int a, int b) {

        // Base Case
        if (a == 0)
            return b;

        // Self-Work
        return gcd(b % a, a);
    }

    public static void main(String[] args) {

    }
}
