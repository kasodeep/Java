package graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * <b>Strongly Connected Component</b> is a component in which we can reach every,
 * vertex of the component from very other vertex in that component. <br>
 * <ul>
 *     <li>Get nodes in Stack.</li>
 *     <li>Transpose the Graph.</li>
 *     <li>Do DFS according to the stack nodes on the transpose graph.</li>
 * </ul>
 */
public class KosarajusAlgorithm {

    public static void kosarajuAlgo(ArrayList<Edge>[] graph, int V) {
        Stack<Integer> st = new Stack<>();
        boolean[] isVisited = new boolean[V];

        // Step 1 - Time Complexity - O(V + E)
        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) TopologicalSorting.topSortUtil(graph, isVisited, i, st);
        }

        // Step 2 - Time Complexity - O(V + E)
        @SuppressWarnings("unchecked") ArrayList<Edge>[] transpose = new ArrayList[V];
        for (int i = 0; i < transpose.length; i++) {
            isVisited[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3 - Time Complexity - O(V + E)
        while (!st.isEmpty()) {
            int curr = st.pop();
            if (!isVisited[curr]) {
                DepthFirstSearch.dfs(transpose, isVisited, curr);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked") ArrayList<Edge>[] graph = new ArrayList[V];
        createGraphDirected(graph);
        kosarajuAlgo(graph, V);
    }

    private static void createGraphDirected(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }
}
