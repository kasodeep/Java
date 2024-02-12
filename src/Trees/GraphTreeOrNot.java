package Trees;

import java.util.*;

public class GraphTreeOrNot {

    public static void main(String[] args) {
        Graph.initGraph(5);
        Graph.addEdge(1, 0);
        Graph.addEdge(0, 2);
        Graph.addEdge(0, 3);
        Graph.addEdge(3, 4);
        if (Graph.isTree())
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");
    }

    static class Graph {
        public static int V;
        public static int E;
        public static ArrayList<ArrayList<Integer>> adj;

        public static void initGraph(int V) {
            Graph.V = V;
            E = 0;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<>());
        }

        static void dfsTraversal(int v, boolean[] visited, int parent) {
            visited[v] = true;
            for (int i : adj.get(v)) if (!visited[i]) dfsTraversal(i, visited, v);
        }

        public static void addEdge(int v, int w) {
            E++;
            adj.get(w).add(v);
            adj.get(v).add(w);
        }

        public static boolean isConnected() {
            boolean[] visited = new boolean[V];
            dfsTraversal(0, visited, -1);

            for (int u = 0; u < V; u++)
                if (!visited[u]) return false;
            return true;
        }

        public static boolean isTree() {
            return isConnected() && E == V - 1;
        }
    }
}
