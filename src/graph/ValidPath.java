package graph;

public class ValidPath {

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointSet set = new DisjointSet(n);
        for (int[] edge : edges) set.union(edge[0], edge[1]);
        return set.find(source) == set.find(destination);
    }
}
