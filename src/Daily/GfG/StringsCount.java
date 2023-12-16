package Daily.GfG;

public class StringsCount {

    static long countStr(long n) {
        return 1 + n + n
                + n * (n - 1) + n * (n - 1) / 2
                + n * (n - 1) * (n - 2) / 2;
    }

    public static void main(String[] args) {

    }
}
