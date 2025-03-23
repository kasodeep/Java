package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Finds the <b>shortest distance</b> from the source to all vertices. <br>
 * It is an example of Greedy Algorithm. <br>
 * We use the concept of <b>Relaxation</b>. <br>
 * For ex: dist[u] + wt < dist[v], then we update the value of dist[v]. <br>
 * Fails when edges weight is <b>Negative.</b>
 */
public class DijkstraAlgorithm {

    // Time Complexity - O(E + E * logV)
    static int[] dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        boolean[] isVisited = new boolean[V];

        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != S) dist[i] = Integer.MAX_VALUE;
        }

        pq.add(new Pair(S, 0));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int curr = p.vertex;

            if (!isVisited[curr]) {
                isVisited[curr] = true;

                for (Pair n : adj.get(curr)) {
                    // Relaxation.
                    if (dist[curr] + n.weight < dist[n.vertex])
                        dist[n.vertex] = dist[curr] + n.weight;
                    pq.add(new Pair(n.vertex, dist[n.vertex]));
                }
            }
        }

        return dist;
    }

    public static class Pair {
        int vertex;
        int weight;

        public Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
