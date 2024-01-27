package Stacks;

import java.util.Stack;

public class ReverseRecursion {

    static void insertAtBottom(Stack<Integer> s, int x) {
        if (s.size() == 0) {
            s.push(x);
            return;
        }

        int temp = s.pop();
        insertAtBottom(s, x);
        s.push(temp);
    }

    static void reverse(Stack<Integer> s) {
        if (s.size() > 0) {
            int top = s.pop();
            reverse(s);
            insertAtBottom(s, top);
        }
    }

    // Time Complexity - O(N^2), Auxiliary Space - O(N).
    public static void main(String[] args) {

    }
}

