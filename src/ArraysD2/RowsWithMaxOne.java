package ArraysD2;

public class RowsWithMaxOne {

    public static int rowWithMax1s(int[][] arr, int n, int m) {
        int maxCount = 0;
        int idx = -1;

        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) if (arr[i][j] == 1) temp++;

            if (temp > maxCount) {
                maxCount = temp;
                idx = i;
            }
        }
        return idx;
    }
}
