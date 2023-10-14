package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Go to immediate neighbors first. <br>
 * It is also called indirect level order traversal. <br>
 * Graph also has disconnected components, which must be accounted.
 */
public class BreadthFirstSearch {

    // Providing start for disconnected components.
    public static void bfs(ArrayList<Edge>[] graph, boolean[] isVisited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!isVisited[curr]) {
                System.out.print(curr + " ");
                isVisited[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // Time Complexity - O(V + E)
    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked") ArrayList<Edge>[] graph = new ArrayList[V];
        AdjacencyList.createGraph(graph);

        boolean[] isVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) bfs(graph, isVisited, i);
        }
    }
}
