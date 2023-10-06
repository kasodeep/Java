package graph;

import java.util.ArrayList;

/**
 * Using List of Lists to implement Graph.
 * Graph size will be equal to number of vertices.
 * */
public class AdjacencyList {

    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked") ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println("{" + e.src + "->" + e.dest + "}");
        }
    }
}

