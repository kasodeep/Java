package Recursion;

public class parseInt {

    public static int parse(String str, int n) {
        if (n == 0) return str.charAt(0) - '0';
        return (parse(str, n - 1) * 10 + str.charAt(n) - '0');
    }

    public static void main(String[] args) {
        String s = "893";
        System.out.println(s);
        System.out.println(parse(s, s.length() - 1));
    }
}
