package graph;

import java.util.ArrayList;

/**
 * Uses the concept of <b>Dynamic Programming.</b>
 * Works perfectly for both positive and negative Edges. <br>
 * Does not work for <b>negative weight cycle.</b>
 */
public class BellManFordAlgorithm {

    // Time Complexity - O(V * E)
    public static void bellManFord(ArrayList<EdgeW>[] graph, int src, int V) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) dist[i] = Integer.MAX_VALUE;
        }

        for (int k = 0; k < V - 1; k++) { // O(V)
            for (int i = 0; i < V; i++) { // O(E) for both the loops.
                for (int j = 0; j < graph[i].size(); j++) {
                    EdgeW e = graph[i].get(j);

                    // Relaxation.
                    if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.wt < dist[e.dest])
                        dist[e.dest] = dist[e.src] + e.wt;
                }
            }
        }

        // To check for -ve weight cycles, we try to run the inner loops again.
        // If there is update, we say negative weight cycle.

        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked") ArrayList<EdgeW>[] graph = new ArrayList[V];
        createGraph(graph);
        bellManFord(graph, 0, V);
    }

    private static void createGraph(ArrayList<EdgeW>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new EdgeW(0, 1, 2));
        graph[0].add(new EdgeW(0, 2, 4));

        graph[1].add(new EdgeW(1, 2, -4));
        graph[2].add(new EdgeW(2, 3, 2));

        graph[3].add(new EdgeW(3, 4, 4));
        graph[4].add(new EdgeW(4, 1, -1));
    }
}
