package ArraysD2;

public class PascalTriangle {

    static int[][] pascal(int n) {

        // Jagged Arrays - no fixed column size.
        int[][] ans = new int[n][];

        for (int i = 0; i < n; i++) {
            ans[i] = new int[i + 1];
            ans[i][0] = ans[i][i] = 0;

            for (int j = 1; j < i; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i - 1][j - 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
