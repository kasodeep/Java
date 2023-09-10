package queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeating {

    final static int MAX_CHAR = 26;

    static void firstNonRepeating(String str) {
        int[] charCount = new int[MAX_CHAR];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            charCount[ch - 'a']++;

            while (!q.isEmpty()) {
                if (charCount[q.peek() - 'a'] > 1)
                    q.remove();
                else {
                    System.out.print(q.peek() + " ");
                    break;
                }
            }

            if (q.isEmpty())
                System.out.print(-1 + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str = "aabc";
        firstNonRepeating(str);
    }
}
