package Basics;

public class ProblemsLoops {

    public static void main(String[] args) {

        reverseNumber();
        seriesSum();
    }

    public static void reverseNumber() {
        int n = 123;
        int ans = 0;

        while (n > 0) {
            int reminder = n % 10;
            ans = ans * 10 + reminder;
            n /= 10;
        }
        System.out.println(ans);
    }

    public static void seriesSum() {
        int n = 5;
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                ans -= i;
            else
                ans += i;
        }
        System.out.println(ans);
    }
}
