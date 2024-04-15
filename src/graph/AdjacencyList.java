package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Using List of Lists to implement Graph.
 * Graph size will be equal to number of vertices.
 */
public class AdjacencyList {

    public List<List<Integer>> printGraph(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
        return graph;
    }
}

