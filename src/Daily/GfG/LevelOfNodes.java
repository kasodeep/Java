package Daily.GfG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOfNodes {

    public static int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
        boolean[] isVisited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        int level = 0;
        while (!q.isEmpty()) {
            int s = q.size();

            while (s != 0) {
                int curr = q.remove();
                if (curr == X) return level;
                isVisited[curr] = true;

                for (int k : adj.get(curr)) {
                    if (!isVisited[k]) q.add(k);
                }
                s--;
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
