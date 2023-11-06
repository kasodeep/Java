package Daily.GfG;

import java.util.ArrayList;
import java.util.List;

public class LettersCollection {

    static List<Integer> matrixSum(int n, int m, int[][] mat, int q, int[][] queries) {
        List<Integer> ans = new ArrayList<>(queries.length);
        for (int[] query : queries) ans.add(getHopSum(mat, n, m, query[1], query[2], query[0]));
        return ans;
    }

    private static int getHopSum(int[][] mat, int n, int m, int i, int j, int dia) {
        int startX = i - dia;
        int startY = j - dia;
        int stopX = i + dia;
        int stopY = j + dia;

        int sum = 0;

        // Top Boundary
        for (int x = startX; x < stopX; x++) {
            if (x >= 0 && x < n && startY >= 0 && startY < m)
                sum += mat[x][startY];
        }

        // Right Boundary
        for (int y = startY; y < stopY; y++) {
            if (stopX >= 0 && stopX < n && y >= 0 && y < m)
                sum += mat[stopX][y];
        }

        // Bottom Boundary
        for (int x = stopX; x > startX; x--) {
            if (x >= 0 && x < n && stopY >= 0 && stopY < m)
                sum += mat[x][stopY];
        }

        // Left Boundary
        for (int y = stopY; y > startY; y--) {
            if (startX >= 0 && startX < n && y >= 0 && y < m)
                sum += mat[startX][y];
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
