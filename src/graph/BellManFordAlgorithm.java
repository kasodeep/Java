package graph;

import java.util.ArrayList;

/**
 * Uses the concept of <b>Dynamic Programming.</b>
 * Works perfectly for both positive and negative Edges. <br>
 * Does not work for <b>negative weight cycle.</b>
 */
public class BellManFordAlgorithm {

    // Time Complexity - O(V * E)
    public static void bellManFord(ArrayList<ArrayList<Pair<Integer, Integer>>> adj, int src, int V) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) dist[i] = Integer.MAX_VALUE;
        }

        for (int k = 0; k < V - 1; k++) { // O(V)
            for (int i = 0; i < V; i++) { // O(E) for both the loops.
                for (Pair<Integer, Integer> e : adj.get(i)) {

                    // Relaxation.
                    if (dist[e.dest()] != Integer.MAX_VALUE && dist[i] + e.weight() < dist[e.dest()])
                        dist[e.dest()] = dist[i] + e.weight();
                }
            }
        }

        /* To check for -ve weight cycles, we try to run the inner loops again.
        If there is update, we say negative weight cycle. */
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}
