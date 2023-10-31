package Daily.LeetCode;

public class OriginalArrayXOR {

    public static int[] findArray(int[] pref) {
        int n = pref.length;
        for (int i = n - 1; i > 0; i--) pref[i] = pref[i] ^ pref[i - 1];
        return pref;
    }

    public static void main(String[] args) {

    }
}
