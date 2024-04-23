package graph;

import java.util.*;

public class Graph<T> {
    private final Map<T, List<Pair<T, Integer>>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(T u, T v, int dist, boolean bidirectional) {
        adjacencyList.putIfAbsent(u, new ArrayList<>());
        adjacencyList.putIfAbsent(v, new ArrayList<>());

        adjacencyList.get(u).add(new Pair<>(v, dist));
        if (bidirectional) adjacencyList.get(v).add(new Pair<>(u, dist));
    }

    public void printAdjacencyList() {
        for (Map.Entry<T, List<Pair<T, Integer>>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (Pair<T, Integer> pair : entry.getValue()) {
                System.out.print("( " + pair.dest() + " , " + pair.weight() + " ) ");
            }
            System.out.println();
        }
    }

    public void bfs(T start) {
        Map<T, Boolean> visited = new HashMap<>();
        Queue<T> queue = new LinkedList<>();

        queue.offer(start);
        visited.put(start, true);

        while (!queue.isEmpty()) {
            T current = queue.poll();
            System.out.print(current + " -> ");

            for (Pair<T, Integer> neighbour : adjacencyList.get(current)) {
                if (!visited.getOrDefault(neighbour.dest(), false)) {
                    visited.put(neighbour.dest(), true);
                    queue.offer(neighbour.dest());
                }
            }
        }
        System.out.println();
    }

    public void dfsUtility(T start) {
        Map<T, Boolean> visited = new HashMap<>();
        dfsHelper(start, visited);
    }

    private void dfsHelper(T current, Map<T, Boolean> visited) {
        visited.put(current, true);
        System.out.print(current + " -> ");

        for (Pair<T, Integer> neighbour : adjacencyList.get(current)) {
            if (!visited.getOrDefault(neighbour.dest(), false)) {
                dfsHelper(neighbour.dest(), visited);
            }
        }
    }

    public void dijkstra(T start) {
        Map<T, Integer> dist = new HashMap<>();
        PriorityQueue<Pair<T, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Pair::weight));

        for (T key : adjacencyList.keySet()) {
            dist.put(key, Integer.MAX_VALUE);
        }

        dist.put(start, 0);
        priorityQueue.add(new Pair<>(start, 0));

        while (!priorityQueue.isEmpty()) {
            Pair<T, Integer> current = priorityQueue.poll();
            T currentNode = current.dest();

            for (Pair<T, Integer> neighbour : adjacencyList.get(currentNode)) {
                int newDist = current.weight() + neighbour.weight();
                if (newDist < dist.get(neighbour.dest())) {
                    dist.put(neighbour.dest(), newDist);
                    priorityQueue.add(new Pair<>(neighbour.dest(), newDist));
                }
            }
        }

        for (Map.Entry<T, Integer> entry : dist.entrySet()) {
            System.out.println(entry.getKey() + " and " + entry.getValue());
        }
    }
}