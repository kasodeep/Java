package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {

    public static String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') r.offer(i);
            else d.offer(i);
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int v1 = r.poll();
            @SuppressWarnings("DataFlowIssue") int v2 = d.poll();

            if (v1 < v2) r.offer(senate.length() + v1);
            else d.offer(senate.length() + v2);
        }
        return r.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {

    }
}
