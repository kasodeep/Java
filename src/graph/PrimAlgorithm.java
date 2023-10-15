package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * A <b>Minimum Spanning</b> tree is a subset of the edges of a connected,
 * edge-weighted undirected graph that connects all the vertices together,
 * without any cycles and with minimum possible total edge weight.
 */
public class PrimAlgorithm {

    // Time Complexity - O(E * log(E))
    public static void prims(ArrayList<EdgeW>[] graph, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[V];
        int mstCost = 0;

        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (!isVisited[curr.node]) {
                isVisited[curr.node] = true;
                mstCost += curr.cost;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    EdgeW e = graph[curr.node].get(i);

                    // IMP: We are adding all the costs of edge.
                    if (!isVisited[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }

        System.out.println("Minimum cost: " + mstCost);
    }

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked") ArrayList<EdgeW>[] graph = new ArrayList[V];
        createGraph(graph);
        prims(graph, V);
    }

    private static void createGraph(ArrayList<EdgeW>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new EdgeW(0, 1, 10));
        graph[0].add(new EdgeW(0, 2, 15));
        graph[0].add(new EdgeW(0, 3, 30));

        graph[1].add(new EdgeW(1, 0, 10));
        graph[1].add(new EdgeW(1, 3, 40));

        graph[2].add(new EdgeW(2, 0, 15));
        graph[2].add(new EdgeW(2, 3, 50));

        graph[3].add(new EdgeW(3, 1, 40));
        graph[3].add(new EdgeW(3, 2, 50));
    }

    public static class Pair implements Comparable<Pair> {

        int node;

        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }
}
