package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of Kahn's Algorithm.
 * */
public class PreRequisiteTasks {

    public static boolean isPossible(int N, int P, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[N];

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < P; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];

            adj.get(src).add(dest);
            indegree[dest]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int size = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            size++;

            for (int num : adj.get(curr)) {
                indegree[num]--;
                if (indegree[num] == 0) q.add(num);
            }
        }
        return size == N;
    }
}
