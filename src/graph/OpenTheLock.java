package graph;

import java.util.*;

public class OpenTheLock {

    public int openLock(String[] deadEnds, String target) {
        Set<String> deadEnd = new HashSet<>(Arrays.asList(deadEnds));
        Set<String> visited = new HashSet<>();
        Queue<String> que = new LinkedList<>();

        visited.add("0000");
        que.offer("0000");
        int level = 0;

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                String current = que.poll();
                if (current.equals(target)) return level;
                if (deadEnd.contains(current)) continue;

                for (int j = 0; j < 4; j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        char[] digits = current.toCharArray();
                        digits[j] = (char) ((digits[j] - '0' + k + 10) % 10 + '0');
                        String next = new String(digits);

                        if (!visited.contains(next)) {
                            visited.add(next);
                            que.offer(next);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
