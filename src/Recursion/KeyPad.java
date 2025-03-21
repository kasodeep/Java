package Recursion;

import java.util.ArrayList;
import java.util.List;

public class KeyPad {

    private final List<String> res = new ArrayList<>();

    private final String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtrack(0, "", digits);
        return res;
    }

    private void backtrack(int i, String curStr, String digits) {
        if (i == digits.length()) {
            res.add(curStr);
            return;
        }

        String chars = digitToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(i + 1, curStr + c, digits);
        }
    }
}
