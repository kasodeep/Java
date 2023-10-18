package Daily.GfG;

import java.util.*;

/**
 * Great Question of graph, Concept is Building.
 */
public class EventualSafeNodes {

    public static List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> safeNodes = new ArrayList<>();
        int[] state = new int[V];

        for (int i = 0; i < V; i++) {
            if (isSafeNode(i, adj, state)) safeNodes.add(i);
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }

    private static boolean isSafeNode(int node, List<List<Integer>> adj, int[] state) {
        if (state[node] != 0) return state[node] == 2;
        state[node] = 1;

        for (int neighbour : adj.get(node)) {
            if (!isSafeNode(neighbour, adj, state)) return false;
        }
        state[node] = 2;
        return true;
    }

    public static void main(String[] args) {

    }
}
