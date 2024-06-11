package dp.adjacentproblems;

/**
 * When we replace 0 from its position we have two choice.
 * I have n - 1 permutations to place 0.
 * Either the number is swapped with zero, or another number is.
 */
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
