package graph;

import java.util.HashSet;

public class MakeNetworkConnected {

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        DisjointSet set = new DisjointSet(n);

        for (int[] arr : connections) {
            set.union(arr[0], arr[1]);
        }

        HashSet<Integer> temp = new HashSet<>();
        for (int i = 0; i < n; i++) temp.add(set.find(i));
        return temp.size() - 1;
    }
}
