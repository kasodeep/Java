package Daily.LeetCode;

public class PowerOfFour {

    public static boolean isPowerOfFour(int n) {
        return n != 0 && ((n & (n - 1)) == 0) && (n & 0xAAAAAAAA) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(64));
    }
}
