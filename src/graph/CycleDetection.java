package graph;

import java.util.ArrayList;

/**
 * Detect cycle for both directed and un-directed graph. </br>
 */
public class CycleDetection {

    /**
     * Using an extra boolean array to check for the cycle.
     */
    public static boolean detectCycleDirected(ArrayList<Edge>[] graph, boolean[] isVisited, int curr, boolean[] recStack) {
        isVisited[curr] = true;
        recStack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (recStack[e.dest]) {
                return true;
            } else if (!isVisited[e.dest] && detectCycleDirected(graph, isVisited, e.dest, recStack)) {
                return true;
            }
        }

        recStack[curr] = false;
        return false;
    }

    /**
     * There are 3 types of neighbours:
     * 1) Visited and Not Parent.
     * 2) Visited and Parent. (DO NOTHING).
     * 3) Not Visited.
     */
    public static boolean detectCycleUndirected(ArrayList<Edge>[] graph, boolean[] isVisited, int curr, int parent) {
        isVisited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (isVisited[e.dest] && parent != e.dest) {
                return true;
            }
            if (!isVisited[e.dest] && detectCycleUndirected(graph, isVisited, e.dest, curr)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked") ArrayList<Edge>[] graph = new ArrayList[V];
        AdjacencyList.createGraphDirected(graph);

        // Checking for Directed Graph.
        boolean[] isVisited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                boolean isCycle = detectCycleDirected(graph, isVisited, i, recStack);
                if (isCycle) {
                    System.out.println(isCycle);
                    break;
                }
            }
        }

    }
}
