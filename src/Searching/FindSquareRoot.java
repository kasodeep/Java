package Searching;

public class FindSquareRoot {

    static int sqrt(int x) {
        int st = 0, end = x / 2, ans = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            int value = mid * mid;
            if (x == value) {
                return mid;
            } else if (x > value) {
                ans = mid;
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 196;
        System.err.println(sqrt(x));
    }
}
