package Daily.LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class SortTheVowels {

    public static String sortVowels(String s) {
        char[] text = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();

        for (char ch : text) if (isVowel(ch)) list.add(ch);
        Collections.sort(list);

        int j = 0;
        for (int i = 0; i < text.length; i++) {
            if (isVowel(text[i])) {
                text[i] = list.get(j++);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char ch : text) ans.append(ch);
        return ans.toString();
    }

    public static boolean isVowel(char x) {
        return x == 'a' || x == 'e' || x == 'i' ||
                x == 'o' || x == 'u' || x == 'A' ||
                x == 'E' || x == 'I' || x == 'O' || x == 'U';
    }

    public static void main(String[] args) {

    }
}
