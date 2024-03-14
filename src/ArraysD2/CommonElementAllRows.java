package ArraysD2;

import java.util.HashMap;
import java.util.Map;

public class CommonElementAllRows {

    public static void findCommon(int[][] mat, int M, int N) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int j = 0; j < N; j++) mp.put(mat[0][j], 1);

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mp.containsKey(mat[i][j]) && mp.get(mat[i][j]) == i)
                    mp.put(mat[i][j], i + 1);
                if (i == M - 1)
                    System.out.print(mat[i][j] + " ");
            }
        }
    }
}
