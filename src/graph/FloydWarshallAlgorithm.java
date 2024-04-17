package graph;

public class FloydWarshallAlgorithm {

    // Time Complexity - O(V^3)
    public static void floydWarshall(int[][] dist) {
        int V = dist.length;
        int i, j, k;

        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] == -1 || dist[k][j] == -1) continue;
                    int part = dist[i][k] + dist[k][j];

                    if (dist[i][j] == -1) dist[i][j] = part;
                    else dist[i][j] = Math.min(dist[i][j], part);
                }
            }
        }
    }
}
