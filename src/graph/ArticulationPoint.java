package graph;

import java.util.ArrayList;

/**
 * A vertex in an undirected connected graph is an articulation point if removing it disconnects the graph.
 */
public class ArticulationPoint {

    // Time Complexity - O(V + E).
    public static void getAP(ArrayList<Edge>[] graph, int V){
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;

        boolean[] isVisited = new boolean[V];
        boolean[] ap = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!isVisited[i]) dfs(graph, i, isVisited, dt, low, time, -1, ap);
        }

        System.out.println("Articulation Points: ");
        for (int i = 0; i < V; i++) {
            if(ap[i]) System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] isVisited, int[] dt, int[] low, int time, int parent, boolean[] ap) {
        isVisited[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neighbour = e.dest;

            if(parent == neighbour){
                continue;
            }else if(isVisited[neighbour]){
                low[curr] = Math.min(low[curr], dt[neighbour]);
            } else{
                dfs(graph, neighbour, isVisited, dt, low, time, curr, ap);
                low[curr] = Math.min(low[curr], low[neighbour]);

                if(dt[curr] <= low[neighbour] && parent != -1) ap[curr] = true;
                children++;
            }
        }

        if(parent == -1 && children > 1) ap[curr] = true;
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked") ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        getAP(graph, V);
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
        graph[4].add(new Edge(4, 3));
    }
}
