package dp;

public class AssemblyLineScheduling {

    public static int carAssembly(int n, int[][] a, int[][] t, int[] e, int[] x) {
        int pre1 = x[1] + a[1][n - 1];
        int pre0 = x[0] + a[0][n - 1];
        int cur1, cur0;

        for (int i = n - 2; i >= 0; i--) {
            cur1 = Math.min(a[1][i] + pre1, a[1][i] + t[1][i + 1] + pre0);
            cur0 = Math.min(a[0][i] + pre0, a[0][i] + t[0][i + 1] + pre1);
            pre1 = cur1;
            pre0 = cur0;
        }

        return Math.min(e[0] + pre0, e[1] + pre1);
    }
}
