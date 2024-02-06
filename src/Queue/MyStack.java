package Queue;

import java.util.LinkedList;
import java.util.Queue;

// This code is push efficient.
public class MyStack {

    Queue<Integer> q = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        for (int i = 1; i <= q.size() - 1; i++) {
            q.add(q.remove());
        }
        return q.remove();
    }

    public int top() {
        for (int i = 1; i <= q.size() - 1; i++) {
            q.add(q.remove());
        }

        int val = q.remove();
        q.add(val);
        return val;
    }

    public boolean empty() {
        return q.size() == 0;
    }
}

