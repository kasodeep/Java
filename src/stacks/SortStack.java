package stacks;

import java.util.Stack;

public class SortStack {

    public static void sortStack(Stack<Integer> s) {
        if (s.empty())
            return;

        int x = s.pop();
        sortStack(s);

        Stack<Integer> tempStack = new Stack<>();
        while (!s.empty() && s.peek() > x) {
            tempStack.push(s.pop());
        }
        s.push(x);

        while (!tempStack.empty()) {
            s.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {

    }
}
