package String;

public class ValidParenthesisString {

    public static boolean checkValidString(String s) {
        int leftCount = 0, rightCount = 0;

        for (char c : s.toCharArray()) {
            leftCount += (c == '(' || c == '*') ? 1 : -1;
            if (leftCount < 0) return false;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            rightCount += (c == ')' || c == '*') ? 1 : -1;
            if (rightCount < 0) return false;
        }
        return true;
    }
}
