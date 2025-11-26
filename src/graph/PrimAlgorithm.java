package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A <b>Minimum Spanning</b> tree is a subset of the edges of a connected,
 * edge-weighted undirected graph that connects all the vertices together,
 * without any cycles and with minimum possible total edge weight.
 */
public class PrimAlgorithm {

    // Time Complexity - O(E * log(E))
    public static void prims(ArrayList<ArrayList<Pair>> adj, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        boolean[] isVisited = new boolean[V];
        int mstCost = 0;

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int curr = p.vertex;

            if (!isVisited[curr]) {
                isVisited[curr] = true;
                mstCost += p.weight;

                for (int i = 0; i < adj.get(curr).size(); i++) {
                    Pair n = adj.get(curr).get(i);

                    // IMP: We are adding all the costs of edge.
                    if (!isVisited[n.vertex]) {
                        pq.add(new Pair(n.vertex, n.weight));
                    }
                }
            }
        }

        System.out.println("Minimum cost:" + mstCost);
    }

    public static class Pair {
        int vertex;
        int weight;

        public Pair(int node, int cost) {
            this.vertex = node;
            this.weight = cost;
        }
    }
}
