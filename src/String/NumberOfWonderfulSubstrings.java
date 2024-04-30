package String;

import java.util.HashMap;

public class NumberOfWonderfulSubstrings {

    public static long wonderfulSubstrings(String word) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        long prefixPattern = 0, ans = 0;
        for (char ch : word.toCharArray()) {
            prefixPattern = (prefixPattern ^ (1L << (ch - 'a')));
            ans += map.getOrDefault(prefixPattern, 0);

            for (char c = 'a'; c <= 'j'; c++) {
                long oddPattern = (prefixPattern ^ (1 << (c - 'a')));
                ans += map.getOrDefault(oddPattern, 0);
            }
            map.put(prefixPattern, map.getOrDefault(prefixPattern, 0) + 1);
        }
        return ans;
    }
}
