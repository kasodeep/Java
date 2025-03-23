package graph;

import java.util.ArrayList;
import java.util.Collections;

public class CriticalConnections {

    static int time = 0;

    public static ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj) {
        return getBridges(adj, v);
    }

    public static ArrayList<ArrayList<Integer>> getBridges(ArrayList<ArrayList<Integer>> adj, int v) {
        int[] dt = new int[v];
        int[] low = new int[v];
        boolean[] vis = new boolean[v];

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        dfs(adj, vis, dt, low, 0, -1, ans);

        ans.sort((a, b) -> {
            if (a.get(0).equals(b.get(0))) {
                return a.get(1) - b.get(1);
            } else {
                return a.getFirst() - b.getFirst();
            }
        });

        return ans;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] dt, int[] low, int curr, int parent, ArrayList<ArrayList<Integer>> ans) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int dest : adj.get(curr)) {
            if (dest == parent) continue;

            if (!vis[dest]) {
                dfs(adj, vis, dt, low, dest, curr, ans);
                low[curr] = Math.min(low[curr], low[dest]);

                // Bridge condition.
                if (dt[curr] < low[dest]) {
                    ArrayList<Integer> bridge = new ArrayList<>();
                    bridge.add(curr);
                    bridge.add(dest);

                    Collections.sort(bridge);
                    ans.add(bridge);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[dest]);
            }
        }
    }
}
