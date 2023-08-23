package Recursion;

public class StringRecursion {

    static String removeOccurrences(String s, char ch) {
        // Base Case
        if (s.length() == 0)
            return "";

        if (s.charAt(0) != ch) {
            return s.charAt(0) + removeOccurrences(s.substring(1), ch);
        } else {
            return removeOccurrences(s.substring(1), ch);
        }
    }

    static boolean isPalindrome(String s, int l, int r) {
        if (l >= r)
            return true;
        return (s.charAt(l) == s.charAt(r) && isPalindrome(s, l + 1, r - 1));
    }

    public static void main(String[] args) {
        String s = "abcdass";
        String string = "idblbdi";

        System.out.println(isPalindrome(string, 0, string.length() - 1));
        System.out.println(removeOccurrences(s, 'c'));
    }
}
