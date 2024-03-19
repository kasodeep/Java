package dp.commonsubsequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);

        Boolean[] dp = new Boolean[s.length() + 1];
        return helper(res, s, new ArrayList<>(), set, 0, dp);
    }

    public static boolean helper(List<String> res, String s, List<String> list, Set<String> set, int index, Boolean[] dp) {
        if (index == s.length()) return true;
        if (dp[index] != null) return dp[index];

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);

            if (set.contains(sub)) {
                list.add(sub);
                if (helper(res, s, list, set, i + 1, dp)) {
                    return dp[index] = true;
                }
                list.remove(list.size() - 1);
            }
        }
        return dp[index] = false;
    }
}
