package graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * <p>Topological sorting is used only for DAG's (Directed Acyclic Graph). <br>
 * It is a linear order of vertices such that every directed edge u -> v, the vertex u comes before v in the order. </p>
 * It represents dependency.
 */
public class TopologicalSorting {

    public static void topSortUtil(ArrayList<Edge>[] graph, boolean[] isVisited, int curr, Stack<Integer> st) {
        isVisited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVisited[e.dest]) topSortUtil(graph, isVisited, e.dest, st);
        }
        st.push(curr);
    }

    public static void topSort(ArrayList<Edge>[] graph, int V) {
        boolean[] isVisited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                topSortUtil(graph, isVisited, i, st);
            }
        }

        while (st.size() > 0) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked") ArrayList<Edge>[] graph = new ArrayList[V];
        AdjacencyList.createGraphTopological(graph);
        topSort(graph, V);
    }
}
