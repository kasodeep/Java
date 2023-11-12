package Daily.GfG;

public class RotatedByTwo {

    public static boolean check(String s, String p) {
        int i = 0;
        int n = s.length();

        while (i < n) {
            if (s.charAt(i) != p.charAt((i + 2) % n)) return false;
            i++;
        }
        return true;
    }

    public static boolean isRotated(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        return check(str1, str2) || check(str2, str1);
    }

    public static void main(String[] args) {

    }
}
