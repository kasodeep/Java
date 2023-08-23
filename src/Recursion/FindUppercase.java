package Recursion;

public class FindUppercase {

    static String uppercase(String a, int idx) {
        // Base-Case
        if (idx == a.length()) return "";

        if (Character.isUpperCase(a.charAt(idx))) return a.substring(idx);
        return uppercase(a, idx + 1);
    }

    public static void main(String[] args) {
        System.out.println(uppercase("physicsWallah", 0));
    }
}
