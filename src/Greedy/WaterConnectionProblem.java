package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class WaterConnectionProblem {

    ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> d) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] m = new int[n + 1];
        int[] cost = new int[n + 1];

        for (int i = 0; i < p; i++) {
            m[a.get(i)] = b.get(i);
            cost[b.get(i)] = d.get(i);
        }

        for (int i = 1; i <= n; i++) {
            if (cost[i] == 0 && m[i] != 0) {
                int end = i;
                int dia = Integer.MAX_VALUE;

                while (m[end] != 0) {
                    end = m[end];
                    dia = Math.min(dia, cost[end]);
                }

                ans.add(new ArrayList<>(Arrays.asList(i, end, dia)));
            }
        }

        return ans;
    }
}
