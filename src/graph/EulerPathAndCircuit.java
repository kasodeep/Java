package graph;

import java.util.List;

/**
 * Euler circuit must have all node with even degree.
 * Euler path must have all even degree node with at most 2 odd degree nodes.
 */
public class EulerPathAndCircuit {

    public static int isEulerCircuit(int V, List<Integer>[] adj) {
        int odd = 0, even = 0;
        for (int i = 0; i < V; i++) {
            if (adj[i].size() % 2 == 0) even++;
            else odd++;
        }

        if (even == V) return 2;
        else if (odd == 2) return 1;
        return 0;
    }

    public static int isPossible(int[][] paths) {
        for (int[] row : paths) {
            if (sumOfArray(row) % 2 != 0) return 0;
        }
        return 1;
    }

    private static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        return sum;
    }
}
