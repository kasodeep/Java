package graph;

import java.util.ArrayList;

public class DetectCycleDirected {

    // Time Complexity - O(V + E)
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] isVisited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                boolean isCycle = detectCycleDirected(adj, isVisited, i, recStack);
                if (isCycle) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleDirected(ArrayList<ArrayList<Integer>> adj, boolean[] isVisited, int curr, boolean[] recStack) {
        isVisited[curr] = true;
        recStack[curr] = true;

        ArrayList<Integer> neighbours = adj.get(curr);
        for (int dest : neighbours) {
            if (recStack[dest]) {
                return true;
            } else if (!isVisited[dest] && detectCycleDirected(adj, isVisited, dest, recStack)) {
                return true;
            }
        }

        recStack[curr] = false;
        return false;
    }
}
