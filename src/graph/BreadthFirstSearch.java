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

    // Time Complexity - O(V + E)
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        boolean[] isVisited = new boolean[V];
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!isVisited[curr]) {
                list.add(curr);
                isVisited[curr] = true;

                ArrayList<Integer> neighbours = adj.get(curr);
                for (int dest : neighbours) q.add(dest);
            }
        }
        return list;
    }
}
