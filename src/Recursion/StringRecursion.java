package Recursion;

public class StringRecursion {

    // String small+curr takes linear time Time-Complexity-O(N^2)
    static String removeA(String s, int idx) {

        // Base Case
        if (idx == s.length())
            return "";

        // Recursion
        String smallAns = removeA(s, idx + 1);

        // Self-Work
        char currChar = s.charAt(idx);
        if (currChar != 'a') {
            return currChar + smallAns;
        } else {
            return smallAns;
        }
    }

    static String removeA2(String s) {

        // Base Case
        if (s.length() == 0)
            return "";

        // Recursion
        String smallAns = removeA2(s.substring(1));

        // Self-Work
        char currChar = s.charAt(0);
        if (currChar != 'a') {
            return currChar + smallAns;
        } else {
            return smallAns;
        }
    }

    static boolean isPalindrome(String s, int l, int r) {
        if (l >= r)
            return true;
        return (s.charAt(l) == s.charAt(r) && isPalindrome(s, l + 1, r - 1));
    }

    public static void main(String[] args) {

    }
}
