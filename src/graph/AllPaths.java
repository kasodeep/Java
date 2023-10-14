package graph;

import java.util.ArrayList;

/**
 * Print all paths from source to target.
 */
public class AllPaths {

    public static void allPaths(ArrayList<Edge>[] graph, int curr, boolean[] isVisited, String path, int target) {
        if (curr == target) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVisited[e.dest]) {
                isVisited[curr] = true;
                allPaths(graph, e.dest, isVisited, path + " " + e.dest, target);
                isVisited[curr] = false;
            }
        }
    }

    // Time Complexity - O(V * V)
    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked") ArrayList<Edge>[] graph = new ArrayList[V];
        AdjacencyList.createGraph(graph);

        int src = 0, target = 5;
        allPaths(graph, src, new boolean[V], "0", target);
    }
}
