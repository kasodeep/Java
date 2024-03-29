package ArraysD2;

import java.util.Arrays;
import java.util.Comparator;

public class OverlappingIntervals {

    static int getCount(int[][] matrix, int n) {
        Arrays.sort(matrix, Comparator.comparingInt(a -> a[0]));
        int count = 0, i = 0;

        while (i < n) {
            while (i < n - 1 && matrix[i][1] >= matrix[i + 1][0]) {
                matrix[i + 1][0] = matrix[i][0];
                matrix[i + 1][1] = Math.max(matrix[i][1], matrix[i + 1][1]);
                i++;
            }
            i++;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
