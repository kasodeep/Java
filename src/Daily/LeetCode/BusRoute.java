package Daily.LeetCode;

import java.util.*;

public class BusRoute {

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int busStopNumber = routes[i][j];
                ArrayList<Integer> busList = adj.getOrDefault(busStopNumber, new ArrayList<>());
                busList.add(i);
                adj.put(busStopNumber, busList);
            }
        }
        int ans = 0;

        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> busStopVisited = new HashSet<>();
        Set<Integer> busVisited = new HashSet<>();

        queue.addLast(source);
        busStopVisited.add(source);

        while (queue.size() > 0) {
            int size = queue.size();

            while (size-- > 0) {
                int currentStop = queue.removeFirst();
                if (currentStop == target)
                    return ans;

                ArrayList<Integer> busesAvailable = adj.get(currentStop);
                for (int bus : busesAvailable) {
                    if (!busVisited.contains(bus)) {
                        int[] nextStop = routes[bus];
                        for (int stop : nextStop) {
                            if (!busStopVisited.contains(stop)) {
                                queue.addLast(stop);
                                busStopVisited.add(stop);
                            }
                        }
                        busVisited.add(bus);
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
