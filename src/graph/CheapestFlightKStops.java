package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightKStops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int m = flights.length;
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        int[] dist = new int[n];

        Arrays.fill(dist, (int) 1e9);
        q.add(new Tuple(0, src));

        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int stop = it.stops;
            int curr = it.node;

            if (stop > k) continue;

            for (Pair pair : adj.get(curr)) {
                int dest = pair.dest;
                int edW = pair.dist;

                if (dist[curr] + edW < dist[dest]) {
                    dist[dest] = dist[curr] + edW;
                    q.add(new Tuple(stop + 1, dest));
                }
            }
        }
        return (dist[dst] == (int) 1e9) ? -1 : dist[dst];
    }

    static class Pair {
        int dest;
        int dist;

        public Pair(int f, int s) {
            dest = f;
            dist = s;
        }
    }

    static class Tuple {
        int stops;
        int node;

        public Tuple(int s, int n) {
            stops = s;
            node = n;
        }
    }
}
