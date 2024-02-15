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
                return a.get(0) - b.get(0);
            }
        });

        return ans;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] dt, int[] low, int curr, int parent, ArrayList<ArrayList<Integer>> ans) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int node : adj.get(curr)) {
            if (node == parent) continue;

            if (!vis[node]) {
                dfs(adj, vis, dt, low, node, curr, ans);
                low[curr] = Math.min(low[curr], low[node]);

                // Bridge condition.
                if (low[node] > dt[curr]) {
                    ArrayList<Integer> bridge = new ArrayList<>();
                    bridge.add(curr);
                    bridge.add(node);
                    Collections.sort(bridge);
                    ans.add(bridge);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[node]);
            }
        }
    }
}
