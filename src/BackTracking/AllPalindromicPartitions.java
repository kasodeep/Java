package BackTracking;

import java.util.ArrayList;

public class AllPalindromicPartitions {

    static ArrayList<ArrayList<String>> allPalindromicPerms(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 0, s);
        return res;
    }

    private static void helper(ArrayList<ArrayList<String>> res, ArrayList<String> curr, int i, String s) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                curr.add(s.substring(i, j + 1));
                helper(res, curr, j + 1, s);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
