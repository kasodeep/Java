package graph;

public class MColoringProblem {

    static boolean isSafe(int v, boolean[][] graph, int[] color, int c, int V) {
        for (int i = 0; i < V; i++)
            if (graph[v][i] && c == color[i])
                return false;
        return true;
    }

    // A recursive utility function to solve m coloring problem
    static boolean graphColoringUtil(boolean[][] graph, int m, int[] color, int v, int V) {
        if (v == V) return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, color, c, V)) {
                color[v] = c;
                if (graphColoringUtil(graph, m, color, v + 1, V)) return true;
                color[v] = 0;
            }
        }
        return false;
    }

    public boolean graphColoring(boolean[][] graph, int m, int V) {
        int[] color = new int[V];
        return graphColoringUtil(graph, m, color, 0, V);
    }
}
