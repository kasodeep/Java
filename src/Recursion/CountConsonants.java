package Recursion;

public class CountConsonants {

    // Utility function to check if the 'ch' is consonant
    public static boolean isconsonant(char ch) {
        ch = Character.toLowerCase(ch);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return false;
        }
        return true;
    }

    /**
     * 
     * @param a - It is the String in which consonants is to be found
     * @param n - It is the number of characters in 'a'
     * @return - It returns the count of the consonants in 'a'
     */
    static int count(String a, int n) {

        // Base-Case
        if (n == 1) {
            if (isconsonant(a.charAt(0)))
                return 1;
            else
                return 0;
        }

        // Recursion And Self-Work
        if (isconsonant(a.charAt(n - 1)))
            return count(a, n - 1) + 1;
        else
            return count(a, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(count("aeifo", 5));
    }
}
