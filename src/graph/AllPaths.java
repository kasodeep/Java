package graph;

import java.util.ArrayList;

/**
 * Print all paths from source to target.
 */
public class AllPaths {

    // Time Complexity - O(V * V)
    public static void allPaths(ArrayList<ArrayList<Integer>> graph, int curr, boolean[] isVisited, String path, int target) {
        if (curr == target) {
            System.out.println(path);
            return;
        }

        for (int dest : graph.get(curr)) {
            if (!isVisited[dest]) {
                isVisited[curr] = true;
                allPaths(graph, dest, isVisited, path + " " + dest, target);
                isVisited[curr] = false;
            }
        }
    }
}
