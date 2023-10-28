package graph;

import java.util.ArrayList;

public class IsGraphBipartite {

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(-1);
        }

        for (int i = 0; i < n; i++) {
            if (list.get(i) != -1) continue;
            if (!hasEvenLengthCycle(graph, i, 0, list)) return false;
        }
        return true;
    }

    public static boolean hasEvenLengthCycle(int[][] graph, int curr, int color, ArrayList<Integer> list) {
        if (list.get(curr) != -1) return list.get(curr) == color;
        list.set(curr, color);

        for (int neighbor : graph[curr])
            if (!hasEvenLengthCycle(graph, neighbor, 1 - color, list)) return false;
        return true;
    }

    public static void main(String[] args) {

    }
}
