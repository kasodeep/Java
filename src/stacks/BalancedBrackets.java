package stacks;

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
}
