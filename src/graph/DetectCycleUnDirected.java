package graph;

import java.util.ArrayList;

public class DetectCycleUnDirected {

    // Time Complexity - O(V + E)
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] isVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!isVisited[i] && cycle(adj, i, isVisited, -1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean cycle(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] isVisited, int parent) {
        isVisited[curr] = true;

        ArrayList<Integer> neighbours = adj.get(curr);
        for (int dest : neighbours) {
            if (isVisited[dest] && dest != parent) {
                return true;
            } else if (!isVisited[dest] && cycle(adj, dest, isVisited, curr)) {
                return true;
            }
        }
        return false;
    }
}
