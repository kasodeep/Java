package ArraysD2;

import java.util.HashMap;

public class SubMatrixSumTarget {

    public static int numSubMatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int r = 0; r < n; r++) {
            for (int c = 1; c < m; c++) matrix[r][c] = matrix[r][c] + matrix[r][c - 1];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int c1 = 0; c1 < m; c1++) {
            for (int c2 = c1; c2 < m; c2++) {
                map.clear();
                map.put(0, 1);

                int sum = 0;
                for (int[] ints : matrix) {
                    sum += c1 == c2 ? ints[c1] : ints[c2] - ints[c1];
                    if (map.containsKey(sum - target)) count += map.get(sum - target);
                    map.compute(sum, (k, v) -> v == null ? 1 : v + 1);
                }
            }
        }
        return count;
    }
}
