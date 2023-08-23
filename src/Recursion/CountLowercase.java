package Recursion;

public class CountLowercase {

    static int count(String a, int idx) {

        // Base-Case
        if (idx == 0) {
            if (Character.isLowerCase(a.charAt(0))) return 1;
            else return 0;
        }

        // Recursion And Self-Work
        if (Character.isLowerCase(a.charAt(idx)))
            return count(a, idx - 1) + 1;
        else
            return count(a, idx - 1);
    }

    public static void main(String[] args) {
        String name = "CollegeWallah";
        System.out.println(count(name, name.length() - 1));
    }
}
