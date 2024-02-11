package String;

public class PalindromicSubStrings {

    public static int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int even = palindromeCount(s, i, i + 1);
            int odd = palindromeCount(s, i - 1, i + 1);
            ans += even + odd + 1;
        }
        return ans;
    }

    public static int palindromeCount(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) count++;
        return count;
    }
}
