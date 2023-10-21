package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LongestPath {

    public static void longestPath(ArrayList<EdgeW>[] graph, int src, int V) {
        Stack<Integer> st = new Stack<>();
        int[] dist = new int[V];
        boolean[] isVisited = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!isVisited[i])
                topSortUtil(graph, isVisited, i, st);

        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0;

        while (!st.isEmpty()) {
            int u = st.pop();

            if (dist[u] != Integer.MIN_VALUE) {
                for (int i = 0; i < graph[u].size(); i++) {
                    EdgeW e = graph[u].get(i);
                    if (dist[e.dest] < dist[u] + e.wt) dist[e.dest] = dist[u] + e.wt;
                }
            }
        }

        for (int i = 0; i < V; i++)
            if (dist[i] == Integer.MIN_VALUE) System.out.print("INF ");
            else System.out.print(dist[i] + " ");
    }

    private static void topSortUtil(ArrayList<EdgeW>[] graph, boolean[] isVisited, int curr, Stack<Integer> st) {
        isVisited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            EdgeW e = graph[curr].get(i);
            if (!isVisited[e.dest]) topSortUtil(graph, isVisited, e.dest, st);
        }
        st.push(curr);
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked") ArrayList<EdgeW>[] graph = new ArrayList[V];
        createGraph(graph);
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
}
