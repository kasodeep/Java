package graph;

import java.util.ArrayList;

/**
 * Keep going to the first neighbor. (Priority)
 * */
public class DepthFirstSearch {

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] isVisited){
        System.out.print(curr + " ");
        isVisited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!isVisited[e.dest])
                dfs(graph, e.dest, isVisited);
        }
    }

    // Time Complexity - O(V + E)
    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked") ArrayList<Edge>[] graph = new ArrayList[V];
        AdjacencyList.createGraph(graph);

        boolean[] isVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) dfs(graph, 0, isVisited);
        }
    }
}
