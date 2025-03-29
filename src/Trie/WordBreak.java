package Trie;

import java.util.ArrayList;

public class WordBreak {

    public static int wordBreak(String A, ArrayList<String> B) {
        Trie root = new Trie();
        for (String word : B) {
            root.insert(word);
        }

        int ans = solve(root, A) ? 1 : 0;
        return ans;
    }

    public static boolean solve(Trie root, String A) {
        if (A.isEmpty())
            return true;

        for (int i = 1; i <= A.length(); i++) {
            if (root.search(A.substring(0, i)) && solve(root, A.substring(i)))
                return true;
        }
        return false;
    }
}
