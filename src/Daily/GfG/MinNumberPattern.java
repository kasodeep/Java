package Daily.GfG;

import java.util.Stack;

public class MinNumberPattern {

    public static String printMinNumberForPattern(String S) {
        StringBuilder ans = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int num = 1;

        for (int i = 0; i < S.length(); i++) {
            st.push(num++);
            if (S.charAt(i) == 'I') while (!st.isEmpty()) ans.append(st.pop());
        }

        st.push(num);
        while (!st.isEmpty()) ans.append(st.pop());
        return ans.toString();
    }

    public static void main(String[] args) {

    }
}
