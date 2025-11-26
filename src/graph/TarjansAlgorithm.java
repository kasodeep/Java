package graph;

import java.util.ArrayList;

/**
 * <b>Bridge</b> is an edge whose deletion increases the graph's number of connected components.
 * Low is the lowest discovery time of all of my neighbours.
 * DT is the discovery time from src to that vertex.
 */
public class TarjansAlgorithm {

    // Time Complexity = O(V + E)
    public static void getBridge(ArrayList<ArrayList<Integer>> graph, int V) {
        int[] dt = new int[V];
        int[] low = new int[V];

        int time = 0;
        boolean[] isVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) dfs(graph, i, isVisited, dt, low, time, -1);
        }
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int curr, boolean[] isVisited, int[] dt, int[] low, int time, int parent) {
        isVisited[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int dest : graph.get(curr)) {
            if (!isVisited[dest]) {
                dfs(graph, dest, isVisited, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[dest]);

                if (dt[curr] < low[dest]) {
                    System.out.println("Bridge is " + curr + " -> " + dest);
                }
            } else if (dest == parent) {
                continue;
            } else {
                // If the neighbour is visited!
                low[curr] = Math.min(low[curr], dt[dest]);
            }
        }
    }
}
