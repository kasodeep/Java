package graph;

import java.util.*;

public class ParallelCourses3 {

    public static int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : relations) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            graph.get(x).add(y);
            indegree[y]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] maxTime = new int[n];

        for (int node = 0; node < n; node++) {
            if (indegree[node] == 0) {
                queue.add(node);
                maxTime[node] = time[node];
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.remove();

            for (int neighbor : graph.get(node)) {
                maxTime[neighbor] = Math.max(maxTime[neighbor], maxTime[node] + time[neighbor]);
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        int ans = 0;
        for (int node = 0; node < n; node++) {
            ans = Math.max(ans, maxTime[node]);
        }
        return ans;
    }
}


