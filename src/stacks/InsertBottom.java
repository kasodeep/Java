package stacks;

import java.util.*;

public class InsertBottom {

    static Stack<Integer> recur(Stack<Integer> S, int N) {
        if (S.size() == 0) S.push(N);
        else {

            int X = S.pop();
            S = recur(S, N);
            S.push(X);
        }
        return S;
    }

    static void insertToBottom(Stack<Integer> S, int N) {
        S = recur(S, N);

        while (S.size() > 0) {
            System.out.print(S.peek() + " ");
            S.pop();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> S = new Stack<>();
        S.push(5);
        S.push(4);
        S.push(3);
        S.push(2);
        S.push(1);

        int N = 7;
        insertToBottom(S, N);
    }
}

