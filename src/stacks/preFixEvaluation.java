package stacks;

import java.util.Stack;

/**
 * preFix : operator + val + val
 * Travel in backward direction only.
 * Also, v1 is first popped.
 */
public class preFixEvaluation {

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

        String str = "-9/*+5346";
        Stack<Integer> val = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if ((int) ch >= 48 && (int) ch <= 57)
                val.push((int) ch - 48);
            else {
                int v1 = val.pop();
                int v2 = val.pop();
                val.push(perform(ch, v1, v2));
            }
        }
        System.out.println(val.peek());
    }
}
