package dp;

public class CountDeArrangements {

    static int countDer(int n) {
        int[] der = new int[n + 1];
        der[1] = 0;
        der[2] = 1;

        for (int i = 3; i <= n; ++i)
            der[i] = (i - 1) * (der[i - 1] + der[i - 2]);
        return der[n];
    }
}
