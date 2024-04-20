package graph;

import java.util.ArrayList;

/**
 * A vertex in an undirected connected graph is an articulation point if removing it disconnects the graph.
 */
public class ArticulationPoint {

    // Time Complexity - O(V + E).
    public static void getAP(ArrayList<ArrayList<Integer>> graph, int V){
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

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int curr, boolean[] isVisited, int[] dt, int[] low, int time, int parent, boolean[] ap) {
        isVisited[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int neighbour : graph.get(curr)) {
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
}
