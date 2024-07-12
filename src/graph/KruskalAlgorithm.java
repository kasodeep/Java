package graph;

import java.util.ArrayList;
import java.util.Comparator;

public class KruskalAlgorithm {

    private static void kruskals(int V, ArrayList<Edge> edges) {
        edges.sort(new Comparator<>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        int j = 0;
        int noOfEdges = 0;

        int[] parent = new int[V];
        int[] rank = new int[V];
        Edge[] results = new Edge[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        while (noOfEdges < V - 1) {
            Edge nextEdge = edges.get(j);
            int x = findRoot(parent, nextEdge.src);
            int y = findRoot(parent, nextEdge.dest);

            if (x != y) {
                results[noOfEdges] = nextEdge;
                union(parent, rank, x, y);
                noOfEdges++;
            }

            j++;
        }

        int minCost = 0;
        for (int i = 0; i < noOfEdges; i++) minCost += results[i].weight;
        System.out.println("Total cost of MST: " + minCost);
    }

    private static void union(int[] parent, int[] rank, int x, int y) {
        int rootX = findRoot(parent, x);
        int rootY = findRoot(parent, y);

        if (rank[rootY] < rank[rootX]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            rank[rootX] = rootY;
        } else {
            rank[rootY] = rootX;
            rank[rootX]++;
        }
    }

    private static int findRoot(int[] parent, int i) {
        if (parent[i] == i) return parent[i];
        parent[i] = findRoot(parent, parent[i]);
        return parent[i];
    }

    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
}
