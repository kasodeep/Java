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

    public static void kosarajuAlgo(ArrayList<ArrayList<Integer>> graph, int V) {
        Stack<Integer> st = new Stack<>();
        boolean[] isVisited = new boolean[V];

        // Step 1 - Time Complexity - O(V + E)
        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) TopologicalSorting.topSortUtil(graph, isVisited, i, st);
        }

        // Step 2 - Time Complexity - O(V + E)
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            isVisited[i] = false;
            transpose.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int dest : graph.get(i)) {
                transpose.get(dest).add(i);
            }
        }

        // Step 3 - Time Complexity - O(V + E)
        while (!st.isEmpty()) {
            int curr = st.pop();
            if (!isVisited[curr]) {
                ArrayList<Integer> list = new ArrayList<>();
                DepthFirstSearch.solve(transpose, isVisited, curr, list);
                System.out.println(list);
            }
        }
    }
}
