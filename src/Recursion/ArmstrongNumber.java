package Recursion;

/**
 * A number is called an Armstrong number if the sum of all the digits,
 * raised to the power of total number digits is equal to original number.
 */
public class ArmstrongNumber {

    static int pow(int a, int b) {
        if (b == 0)
            return 1;

        if (b % 2 == 0) {
            return pow(a, b / 2) * pow(a, b / 2);
        } else {
            return pow(a, b / 2) * pow(a, b / 2) * a;
        }
    }

    static int ifArmstrong(int n, int m) {
        if (n <= 0) {
            return 0;
        }
        return pow(n % 10, m) + ifArmstrong(n / 10, m);
    }

    public static void main(String[] args) {
        int n = 152;
        int m = ifArmstrong(n, 3);
        if (m == n) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
