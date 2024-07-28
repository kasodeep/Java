package String;

import java.util.Arrays;

public class IsomorphicStrings {

    public static boolean areIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] freqS1 = new int[256];
        int[] freqS2 = new int[256];

        Arrays.fill(freqS1, -1);
        Arrays.fill(freqS2, -1);

        for (int i = 0; i < str1.length(); i++) {
            char ss = str1.charAt(i);
            char tt = str2.charAt(i);

            if (freqS1[ss] == -1 && freqS2[tt] == -1) {
                freqS1[ss] = tt;
                freqS2[tt] = ss;
            } else if (freqS1[ss] != tt || freqS2[tt] != ss) {
                return false;
            }

        }
        return true;
    }
}
