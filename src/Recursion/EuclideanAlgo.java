package Recursion;

public class EuclideanAlgo {

    /**
     * @param a - It is the first number.
     * @param b - It is the second number.
     * @return - It returns the gcd of {a} and {b}
     */
    public static int gcdByDivision(int a, int b) {
        if (a == 0)
            return b;
        return gcdByDivision(b % a, a);
    }

    static int gcdBySubtraction(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
        if (a == b)
            return a;

        if (a > b)
            return gcdBySubtraction(a - b, b);
        return gcdBySubtraction(a, b - a);
    }

    public static void main(String[] args) {
        System.out.println(gcdByDivision(72, 54));
        System.out.println(gcdBySubtraction(72, 54));
    }
}
