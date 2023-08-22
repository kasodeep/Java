package Recursion;

public class GrayCode {

    static int toGrayCode(int num, int idx) {
        int a, b;
        int result = 0;

        if (num != 0) {
            a = num % 10;
            num = num / 10;
            b = num % 10;

            if ((a & ~b) == 1 || (~a & b) == 1) {
                result = (int) (result + Math.pow(10, idx));
            }
            return toGrayCode(num, ++idx) + result;
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 1001;
        System.out.println(toGrayCode(n, 0));
    }
}
