package String;

public class StringRotation {

    static boolean areRotations(String str1, String str2) {
        return (str1.length() == str2.length()) && ((str1 + str1).contains(str2));
    }
}
