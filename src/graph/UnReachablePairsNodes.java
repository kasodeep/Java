package graph;

public class UnReachablePairsNodes {

    public static long countPairs(int n, int[][] edges) {
        DisjointSet set = new DisjointSet(n);
        for (int[] arr : edges) {
            set.union(arr[0], arr[1]);
        }

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[set.find(i)]++;
        }

        long sum = 0;
        long ans = 0;
        for (long num : arr) sum += num;

        for (long num : arr) {
            sum -= num;
            ans += (sum * num);
        }
        return ans;
    }
}
