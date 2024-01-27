package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReorderQueue {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < 9; i++) {
            q.add(i);
        }

        Stack<Integer> st = new Stack<>();
        int n = q.size();

        // 1st Half in Stack.
        for (int i = 1; i <= n / 2; i++) {
            st.push(q.remove());
        }

        // 1st Half after 2nd but in reverse.
        while (st.size() > 0) {
            q.add(st.pop());
        }

        for (int i = 1; i <= n / 2; i++) {
            st.push(q.remove());
        }

        // In Stack -> 8 7 6 5
        // In Queue -> 4 3 2 1
        for (int i = 1; i <= n / 2; i++) {
            q.add(st.pop());
            q.add(q.remove());
        }

        // Reverse the Queue.
        while (q.size() > 0) {
            st.push(q.remove());
        }

        while (st.size() > 0) {
            q.add(st.pop());
        }
        System.out.println(q);
    }
}
