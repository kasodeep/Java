package Greedy;

import java.util.Arrays;

public class MinimumCostToCut {

    public static int minimumCostOfBreaking(int[] X, int[] Y, int m, int n) {
        int res = 0;

        Arrays.sort(X);
        Arrays.sort(Y);

        int horizontalPieces = 1, verticalPieces = 1;
        int i = m - 1, j = n - 1;

        while (i >= 0 && j >= 0) {
            if (X[i] > Y[j]) {
                res += X[i] * verticalPieces;
                horizontalPieces++;
                i--;
            } else {
                res += Y[j] * horizontalPieces;
                verticalPieces++;
                j--;
            }
        }

        int total = 0;
        while (i >= 0) total += X[i--];
        res += total * verticalPieces;

        total = 0;
        while (j >= 0) total += Y[j--];
        res += total * horizontalPieces;

        return res;
    }
}
