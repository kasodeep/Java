package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstK {

    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<>();
        while (st.size() != k) {
            st.push(q.remove());
        }

        while (st.size() != 0) {
            q.add(st.pop());
        }

        int temp = q.size() - k;
        while (temp > 0) {
            q.add(q.remove());
            temp--;
        }
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            q.add(i);
        }

        Queue<Integer> ans = modifyQueue(q, 3);
        for (int i = 0; i < 5; i++) {
            System.out.print(ans.poll() + " ");
        }
    }
}
