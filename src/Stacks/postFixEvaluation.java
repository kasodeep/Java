package Stacks;

import java.util.Stack;

/**
 * postFix : val + val + operator
 * Travel in forward direction only.
 */
public class postFixEvaluation {

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

        String str = "953+4*6/-";
        Stack<Integer> val = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ((int) ch >= 48 && (int) ch <= 57)
                val.push((int) ch - 48);
            else {
                int v2 = val.pop();
                int v1 = val.pop();
                val.push(perform(ch, v1, v2));
            }
        }
        System.out.println(val.peek());
    }
}
