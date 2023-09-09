package stacks;

import java.util.Stack;

/**
 * Infix : val + operator + val
 * For Brackets : if(op.size()==0 || ch=='(') push
 * Don't forget to pop old op and push current op to the op stack.
 */
public class infixEvaluation {

    private static int perform(char ch, int v1, int v2) {
        switch (ch) {
            case '-' -> {
                return v1 - v2;
            }
            case '+' -> {
                return v1 + v2;
            }
            case '*' -> {
                return v1 * v2;
            }
            case '/' -> {
                return v1 / v2;
            }
            default -> {
                return -1;
            }
        }
    }

    public static void main(String[] args) {

        String str = "9-(5+3)*4/6";

        // Two stacks for value and operator.
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        // Iterate over the loop
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If it is a value push it to the val stack.
            if ((int) ch >= 48 && (int) ch <= 57)
                val.push((int) ch - 48);

                // If op stack is empty push the operator.
            else if (op.size() == 0 || ch == '(' || op.peek() == '(')
                op.push(ch);

            else if (ch == ')') {
                while (op.peek() != '(') {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    val.push(perform(op.peek(), v1, v2));
                    op.pop();
                }
                op.pop(); // '(' removed

            } else {
                // if '+' or '-' do the work as there is the least precedence of this two.
                if (ch == '+' || ch == '-') {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    val.push(perform(op.peek(), v1, v2));

                    op.pop();
                    op.push(ch);
                }

                if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        int v2 = val.pop();
                        int v1 = val.pop();
                        val.push(perform(op.peek(), v1, v2));

                        op.pop();
                        op.push(ch);
                    } else {
                        op.push(ch);
                    }
                }
            }
        }

        // Emptying the stack and calculating
        while (val.size() > 1) {
            int v2 = val.pop();
            int v1 = val.pop();
            val.push(perform(op.peek(), v1, v2));
            op.pop();
        }

        System.out.println(val.peek());
    }
}
