package queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCalls {
    static class RecentCounter {
        Queue<Integer> q;

        public RecentCounter() {
            q = new LinkedList<>();
        }

        public int ping(int t) {
            q.add(t);
            while (q.size() > 0 && t - 3000 > q.peek()) q.remove();
            return q.size();
        }
    }
}
