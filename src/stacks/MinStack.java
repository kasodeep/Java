package stacks;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * val < min. Therefore val - min < 0.
 * val + (val - min) < val
 * 2 * val - min < val.
 * Because we are adding a -ve number to value.
 * */
public class MinStack {
    Stack<Long> st;
    long min = -1;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.size() == 0) {
            st.push((long) val);
            min = val;
        } else if ((long) val >= min) {
            st.push((long) val);
        } else if ((long) val < min) {
            st.push(2 * (long) val - min);
            min = val;
        }
    }

    public void pop() {
        if (st.size() == 0) {
            throw new EmptyStackException();
        } else if (st.peek() >= min) {
            st.pop();
        } else if (st.peek() < min) {
            min = 2 * min - st.peek();
            st.pop();
        }
    }

    public int top() {
        if (st.size() == 0) return -1;
        long x = st.peek();
        if (x >= min) return (int) (x);
        if (x < min) return (int) (min);
        return 0;
    }

    public int getMin() {
        if (st.size() == 0) return -1;
        return (int) min;
    }
}

