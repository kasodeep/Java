package Daily.GfG;

import java.util.ArrayList;

public class TransitiveClosure {

    public static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int[][] graph) {
        ArrayList<ArrayList<Integer>> transitiveClosure = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            transitiveClosure.add(new ArrayList<>(N));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j || graph[i][j] == 1) {
                    transitiveClosure.get(i).add(1);
                } else {
                    transitiveClosure.get(i).add(0);
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (transitiveClosure.get(i).get(k) == 1 && transitiveClosure.get(k).get(j) == 1) {
                        transitiveClosure.get(i).set(j, 1);
                    }
                }
            }
        }
        return transitiveClosure;
    }

    public static void main(String[] args) {

    }
}
