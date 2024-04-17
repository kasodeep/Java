package graph;

import java.util.ArrayList;

public class IsGraphBipartite {

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < V; i++) list.add(-1);

        for (int i = 0; i < V; i++) {
            if (list.get(i) != -1) continue;
            if (!color(adj, i, 1, list)) return false;
        }
        return true;
    }

    public static boolean color(ArrayList<ArrayList<Integer>> adj, int curr, int color, ArrayList<Integer> list) {
        if (list.get(curr) != -1) return list.get(curr) == color;
        list.set(curr, color);

        for (int neighbor : adj.get(curr))
            if (!color(adj, neighbor, 1 - color, list)) return false;
        return true;
    }
}
