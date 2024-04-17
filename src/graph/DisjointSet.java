package graph;

public class DisjointSet {

    int[] rank, parent;
    int n;

    public DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];

        this.n = n;
        makeSet();
    }

    private void makeSet() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot == yRoot) return;

        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[yRoot] < rank[xRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}
