package stacks;

import java.util.Stack;

/**
 * In Stack -> get T.C = O(n), S.C = O(1).
 * We use stack to discipline ourselves , since we can only work with top element.
 */
public class Basic {

    public static void main(String[] args) {
        // Using STL
        Stack<Integer> st = new Stack<>();

        // Three major operations
        st.push(10);
        st.push(20);

        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.peek());
    }
}
