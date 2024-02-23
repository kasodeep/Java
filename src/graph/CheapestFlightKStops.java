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
        q.add(new Tuple(0, src, 0));

        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int stop = it.stops;
            int node = it.nodes;
            int dis = it.dist;

            if (stop > k) continue;
            for (Pair curr : adj.get(node)) {
                int currNode = curr.dest;
                int edW = curr.dist;
                if (dis + edW < dist[currNode]) {
                    dist[currNode] = dis + edW;
                    q.add(new Tuple(stop + 1, currNode, dis + edW));
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
        int nodes;
        int dist;

        public Tuple(int s, int n, int d) {
            stops = s;
            nodes = n;
            dist = d;
        }
    }
}
