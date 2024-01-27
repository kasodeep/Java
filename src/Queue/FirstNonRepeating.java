package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeating {

    final static int MAX_CHAR = 26;

    static String firstNonRepeating(String A) {
        int[] ch = new int[26];
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            q.add(A.charAt(i));
            ch[A.charAt(i) - 'a']++;

            while (!q.isEmpty() && ch[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if (!q.isEmpty()) {
                ans.append(q.peek());
            } else {
                ans.append("#");
            }
        }

        return ans.toString();
    }
}
