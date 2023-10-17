package graph;

import java.util.ArrayList;

/**
 * <b>Bridge</b> is an edge whose deletion increases the graph's number of connected components.
 * Low is the lowest discovery time for all the vertex.
 * DT is the discovery time from src to that vertex.
 */
public class TarjansAlgorithm {

    public static void getBridge(ArrayList<Edge>[] graph, int V) {
        int[] dt = new int[V];
        int[] low = new int[V];

        int time = 0;
        boolean[] isVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) dfs(graph, i, isVisited, dt, low, time, -1);
        }
    }

    private static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] isVisited, int[] dt, int[] low, int time, int parent) {
        isVisited[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVisited[e.dest]) {
                dfs(graph, e.dest, isVisited, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[e.dest]);

                if (dt[curr] < low[e.dest]) {
                    System.out.println("Bridge is " + curr + " -> " + e.dest);
                }
            } else if (e.dest == parent) {
                continue;
            } else {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked") ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        getBridge(graph, V);
    }

    private static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }
}
