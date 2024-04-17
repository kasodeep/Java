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
public class DijkstrasAlgorithm {

    // Time Complexity - O(E + E * logV)
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.dist));
        boolean[] isVisited = new boolean[V];

        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != S) dist[i] = Integer.MAX_VALUE;
        }

        pq.add(new Pair(S, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (!isVisited[curr.node]) {
                isVisited[curr.node] = true;

                for (int i = 0; i < adj.get(curr.node).size(); i++) {
                    ArrayList<Integer> e = adj.get(curr.node).get(i);

                    // Relaxation.
                    if (dist[curr.node] + e.get(1) < dist[e.get(0)])
                        dist[e.get(0)] = dist[curr.node] + e.get(1);
                    pq.add(new Pair(e.get(0), dist[e.get(0)]));
                }
            }
        }

        return dist;
    }

    public static class Pair {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}
