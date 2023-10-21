package Daily.GfG;

public class SumOfDivisors {

    public static long sumOfDivisors(int N) {
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += (long) (N / i) * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDivisors(4));
    }
}
