package graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * <p>Topological sorting is used only for DAG's (Directed Acyclic Graph). <br>
 * It is a linear order of vertices such that every directed edge u -> v, the vertex u comes before v in the order. </p>
 * It represents dependency.
 */
public class TopologicalSorting {

    public static void topSortUtil(ArrayList<ArrayList<Integer>> adj, boolean[] isVisited, int curr, Stack<Integer> st) {
        isVisited[curr] = true;
        for (int dest : adj.get(curr)) {
            if (!isVisited[dest]) topSortUtil(adj, isVisited, dest, st);
        }
        st.push(curr);
    }

    public static void topSort(ArrayList<ArrayList<Integer>> graph, int V) {
        boolean[] isVisited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) topSortUtil(graph, isVisited, i, st);
        }

        while (st.size() > 0) {
            System.out.print(st.pop() + " ");
        }
    }
}
