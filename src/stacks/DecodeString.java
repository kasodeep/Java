package stacks;

import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<StringBuilder> string = new Stack<>();

        int n = s.length(), num = 0;
        StringBuilder str = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                num = (num * 10) + ch - '0';
            } else if (ch == '[') {
                string.push(str);
                str = new StringBuilder();

                numbers.push(num);
                num = 0;
            } else if (ch == ']') {
                StringBuilder temp = str;
                str = string.pop();

                int count = numbers.pop();
                while (count-- > 0) str.append(temp);
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {

    }
}
