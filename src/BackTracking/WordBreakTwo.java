package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreakTwo {

    static List<String> wordBreak(int n, List<String> dict, String s) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>(dict);

        helper(res, s, new ArrayList<>(), set, 0);
        return res;
    }

    public static void helper(List<String> res, String s, List<String> list, HashSet<String> set, int index) {
        if (index == s.length()) {
            res.add(String.join(" ", list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (set.contains(sub)) {
                list.add(sub);
                helper(res, s, list, set, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
