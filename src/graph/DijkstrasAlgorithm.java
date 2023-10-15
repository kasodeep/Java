package graph;

import java.util.ArrayList;
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
    public static void dijkstra(ArrayList<EdgeW>[] graph, int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[V];

        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) dist[i] = Integer.MAX_VALUE;
        }

        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (!isVisited[curr.node]) {
                isVisited[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    EdgeW e = graph[curr.node].get(i);

                    // Relaxation.
                    if (dist[e.src] + e.wt < dist[e.dest]) dist[e.dest] = dist[e.src] + e.wt;
                    pq.add(new Pair(e.dest, dist[e.dest]));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked") ArrayList<EdgeW>[] graph = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph, 0, V);
    }

    private static void createGraph(ArrayList<EdgeW>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new EdgeW(0, 1, 2));
        graph[0].add(new EdgeW(0, 2, 4));

        graph[1].add(new EdgeW(1, 3, 7));
        graph[1].add(new EdgeW(1, 2, 1));

        graph[2].add(new EdgeW(2, 4, 3));
        graph[3].add(new EdgeW(3, 5, 1));

        graph[4].add(new EdgeW(4, 3, 2));
        graph[4].add(new EdgeW(4, 5, 5));
    }

    public static class Pair implements Comparable<Pair> {

        int node;

        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;
        }
    }
}
