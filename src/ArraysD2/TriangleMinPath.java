package ArraysD2;

import java.util.List;

public class TriangleMinPath {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();

        Integer[][] memo = new Integer[n + 1][m + 1];
        return minimumTotal(triangle, 0, 0, triangle.size(), memo);
    }

    public static int minimumTotal(List<List<Integer>> triangle, int i, int j, int n, Integer[][] memo) {
        if (i == n) return 0;
        if (memo[i][j] != null) return memo[i][j];
        return memo[i][j] = Math.min(minimumTotal(triangle, i + 1, j, n, memo), minimumTotal(triangle, i + 1, j + 1, n, memo))
                + triangle.get(i).get(j);
    }

    public static void main(String[] args) {

    }
}
