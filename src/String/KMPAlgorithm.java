package String;

import java.util.ArrayList;

public class KMPAlgorithm {

    // Function to compute the Longest Proper Prefix which is also Suffix (LPS) array.
    public static void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0; // Length of the previous longest prefix suffix.
        lps[0] = 0; // lps[0] is always 0.
        int i = 1;

        // Loop to compute the LPS array.
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // Function to search for the pattern in the given text.
    private static ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> res = new ArrayList<>();
        int M = pat.length();
        int N = txt.length();

        int[] lps = new int[M + 1];
        computeLPSArray(pat, M, lps);

        int j = 0; // Index for pattern.
        int f = 0; // Flag to track if the pattern was found.
        int i = 0; // Index for text.

        // Loop to search for the pattern in the text.
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }

            if (j == M) {
                f++;
                res.add(i - j + 1);
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }

        if (f == 0) res.add(-1);
        return res;
    }
}
