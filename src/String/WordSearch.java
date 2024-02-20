package String;

import java.util.ArrayList;
import java.util.HashSet;

public class WordSearch {

    public static int wordBreak(String A, ArrayList<String> B) {
        int n = A.length();
        HashSet<String> wordSet = new HashSet<>(B);

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(A.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n] ? 1 : 0;
    }
}