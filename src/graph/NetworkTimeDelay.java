package graph;

import java.util.*;

public class NetworkTimeDelay {

    public static int networkDelayTime(int[][] times, int n, int k) {

        // Creating Graph.
        @SuppressWarnings("unchecked")
        List<Node>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Initializing Graph.
        for (var t : times) {
            graph[t[0] - 1].add(new Node(t[1] - 1, t[2]));
        }

        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);

        time[--k] = 0;
        boolean[] isVisited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(k);

        while (!q.isEmpty()) {
            int curr = q.poll();
            isVisited[curr] = false;

            for (var next : graph[curr]) {
                if (time[curr] + next.time < time[next.dest]) {
                    time[next.dest] = time[curr] + next.time;

                    if (!isVisited[next.dest]) {
                        q.offer(next.dest);
                        isVisited[next.dest] = true;
                    }
                }
            }
        }

        int res = time[0];
        for (var t : time)
            if (t == Integer.MAX_VALUE) return -1;
            else if (t > res) res = t;
        return res;
    }

    public static void main(String[] args) {

    }

    record Node(int dest, int time) {
    }
}
