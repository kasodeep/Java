package graph;

public class FloydWarshallAlgorithm {

    final static int V = 4;

    // Time Complexity - O(V^3)
    public static void main(String[] args) {
        int[][] graph = {{0, 5, -1, 10},
                {-1, 0, 3, -1},
                {-1, -1, 0, 1},
                {-1, -1, -1, 0}};
        floydWarshall(graph);
    }

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
        printSolution(dist);
    }

    public static void printSolution(int[][] dist) {
        System.out.println("The following matrix shows the shortest " + "distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == -1)
                    System.out.print("-1 ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
