package Stacks;

import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalanced(String str) {
        Stack<Character> st = new Stack<>();
        int n = str.length();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.size() == 0)
                    return false;
                if (st.peek() == '(')
                    st.pop();
            }
        }
        return st.size() == 0;
    }

    public static void main(String[] args) {
        String str = "(())(";
        System.out.println(isBalanced(str));
    }

    public static boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else {
                if (st.isEmpty()) return false;
                if ((st.peek() == '(' && ch == ')') || (st.peek() == '{' && ch == '}') || (st.peek() == '[' && ch == ']'))
                    st.pop();
                else {
                    return false;
                }
            }
        }
        return st.size() == 0;
    }
}
