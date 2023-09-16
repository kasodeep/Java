package stacks;

import java.util.Stack;

public class ReverseRecursion {

    static Stack<Character> st = new Stack<>();

    static void insert_at_bottom(char x) {
        if (st.isEmpty())
            st.push(x);
        else {
            char a = st.pop();
            insert_at_bottom(x);
            st.push(a);
        }
    }

    static void reverse() {
        if (st.size() > 0) {
            char x = st.pop();
            reverse();
            insert_at_bottom(x);
        }
    }

    // Time Complexity - O(N^2), Auxiliary Space - O(N).
    public static void main(String[] args) {
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');

        System.out.println("Original Stack");
        System.out.println(st);
        reverse();
        System.out.println("Reversed Stack");
        System.out.println(st);
    }
}

