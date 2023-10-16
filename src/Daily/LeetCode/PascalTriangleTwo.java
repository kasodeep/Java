package Daily.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleTwo {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        int[][] ans = pascal(rowIndex + 1);

        for (int i = 0; i < ans[rowIndex].length; i++) {
            list.add(ans[rowIndex][i]);
        }
        return list;
    }

    static int[][] pascal(int n) {
        // Jagged Arrays - No fixed column size.
        int[][] ans = new int[n][];

        for (int i = 0; i < n; i++) {
            ans[i] = new int[i + 1];
            ans[i][0] = ans[i][i] = 1;

            for (int j = 1; j < i; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i - 1][j - 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
