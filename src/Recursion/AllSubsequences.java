package Recursion;

public class AllSubsequences {

    public static void printSubsequences(String s, int index, String curr) {
        if (index == s.length()) {
            System.out.println(curr);
            return;
        }

        printSubsequences(s, index + 1, curr + s.charAt(index));
        printSubsequences(s, index + 1, curr);
    }

    public static void main(String[] args) {
        String s = "abc";
        printSubsequences(s, 0, "");
    }
}
