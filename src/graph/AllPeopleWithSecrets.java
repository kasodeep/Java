package graph;

import java.util.*;

public class AllPeopleWithSecrets {

    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] meeting : meetings) {
            graph.get(meeting[0]).add(new Pair(meeting[1], meeting[2]));
            graph.get(meeting[1]).add(new Pair(meeting[0], meeting[2]));
        }

        // Secret knowing time initialization!
        int[] secretTime = new int[n];
        Arrays.fill(secretTime, Integer.MAX_VALUE);
        secretTime[0] = 0;
        secretTime[firstPerson] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(firstPerson);

        // Doing dfs!
        while (q.size() > 0) {
            int curr = q.poll();
            ArrayList<Pair> temp = graph.get(curr);
            if (temp.size() == 0) continue;

            for (Pair pair : temp) {
                if (secretTime[curr] <= pair.time && secretTime[pair.dest] > pair.time) {
                    secretTime[pair.dest] = pair.time;
                    q.add(pair.dest);
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        for (int num : secretTime) {
            if (num != Integer.MAX_VALUE) list.add(i);
            i++;
        }
        return list;
    }

    static class Pair {
        int dest;
        int time;

        public Pair(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }
    }
}
