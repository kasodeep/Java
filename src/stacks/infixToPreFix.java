package stacks;

import java.util.Stack;

public class infixToPreFix {

    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";

        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ((int) ch >= 48 && (int) ch <= 57)
                val.push(String.valueOf(ch));

            else if (op.size() == 0 || ch == '(' || op.peek() == '(')
                op.push(ch);

            else if (ch == ')') {
                while (op.peek() != '(') {
                    String v2 = val.pop();
                    String v1 = val.pop();

                    char o = op.pop();
                    val.push(o + v1 + v2);
                }
                op.pop();
            } else {
                if (ch == '+' || ch == '-') {
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();

                    val.push(o + v1 + v2);
                    op.push(ch);
                }

                if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();

                        val.push(o + v1 + v2);
                        op.push(ch);
                    } else {
                        op.push(ch);
                    }
                }
            }
        }

        // Emptying the stack and calculating
        while (val.size() > 1) {
            String v2 = val.pop();
            String v1 = val.pop();

            char o = op.pop();
            val.push(o + v1 + v2);
        }
        System.out.println(val.peek());
    }
}