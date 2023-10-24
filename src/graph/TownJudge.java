package graph;

public class TownJudge {

    /**
     * indegree - No of parents.
     * outdegree - No of child.
     */
    public static int findJudge(int n, int[][] trust) {
        int[] outdegree = new int[n + 1];
        int[] indegree = new int[n + 1];

        for (int[] arr : trust) {
            int v1 = arr[0];
            int v2 = arr[1];
            outdegree[v1]++;
            indegree[v2]++;
        }

        for (int i = 1; i <= n; i++) {
            if (outdegree[i] == 0 && indegree[i] == n - 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
