package priorityQueue;

import java.util.PriorityQueue;

public class ReorganizeStrings {

    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0)
                pq.offer(new int[]{i, count[i]});
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != cur[0] + 'a') {
                sb.append((char) (cur[0] + 'a'));
                cur[1]--;
            } else {
                if (pq.isEmpty())
                    return "";
                int[] next = pq.poll();
                sb.append((char) (next[0] + 'a'));
                next[1]--;
                if (next[1] > 0)
                    pq.offer(next);
            }
            if (cur[1] > 0)
                pq.offer(cur);
        }
        return sb.toString();
    }
}
