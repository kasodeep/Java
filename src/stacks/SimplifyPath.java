package stacks;

import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] stringsArray = path.trim().split("/");

        for (String s : stringsArray) {
            if (s.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!s.equals("..") && !s.equals(".")) stack.push(s);
        }

        if (stack.isEmpty()) return "/";
        for (String s : stack) if (!s.equals("")) sb.append("/").append(s);
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
