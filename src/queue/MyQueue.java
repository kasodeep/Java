package queue;

import java.util.Stack;

// This code is push efficient.
class MyQueue {

    Stack<Integer> st = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        st.push(x);
    }

    public int pop() {
        while (st.size() > 1) {
            helper.push(st.pop());
        }
        int x = st.pop();

        while (helper.size() > 0) {
            st.push(helper.pop());
        }
        return x;
    }

    public int peek() {
        while (st.size() > 1) {
            helper.push(st.pop());
        }
        int x = st.peek();

        while (helper.size() > 0) {
            st.push(helper.pop());
        }
        return x;
    }

    public boolean empty() {
        return st.size() == 0;
    }
}
