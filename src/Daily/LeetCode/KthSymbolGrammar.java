package Daily.LeetCode;

/**
 * A trick is to convert 0 to 1 and vice-versa, by using X' = 1 - X.
 */
public class KthSymbolGrammar {

    public static int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        int halfElements = 1 << (n - 2);

        if (k <= halfElements) return kthGrammar(n - 1, k);
        else return 1 - kthGrammar(n - 1, k - halfElements);
    }

    public static void main(String[] args) {

    }
}
