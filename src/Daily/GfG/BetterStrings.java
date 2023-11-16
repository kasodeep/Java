package Daily.GfG;

import java.util.HashMap;

public class BetterStrings {

    public static String betterString(String str1, String str2) {
        int count1 = countDistinctSubsequences(str1);
        int count2 = countDistinctSubsequences(str2);

        return (count1 >= count2) ? str1 : str2;
    }

    private static int countDistinctSubsequences(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), -1);
        }

        int allCount = 0;
        int levelCount;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Check if i equal to 0.
            if (i == 0) {
                allCount = 1;
                map.put(c, 1);
                continue;
            }

            // Replace levelCount with allCount + 1.
            levelCount = allCount + 1;

            // If map is less than 0.
            if (map.get(c) < 0)
                allCount = allCount + levelCount;
            else
                allCount = allCount + levelCount - map.get(c);
            map.put(c, levelCount);
        }
        return allCount;
    }

    public static void main(String[] args) {

    }
}
