package graph;

import java.util.ArrayList;

/**
 * Keep going to the first neighbor. (Priority)
 */
public class DepthFirstSearch {

    // Time Complexity - O(V + E)
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] isVisited = new boolean[V];

        solve(adj, isVisited, 0, list);
        return list;
    }

    public static void solve(ArrayList<ArrayList<Integer>> adj, boolean[] isVisited, int curr, ArrayList<Integer> list) {
        list.add(curr);
        isVisited[curr] = true;

        for (int dest : adj.get(curr))
            if (!isVisited[dest]) solve(adj, isVisited, dest, list);
    }
}
