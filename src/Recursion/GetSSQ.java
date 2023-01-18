package Recursion;

import java.util.ArrayList;

public class GetSSQ {

    static ArrayList<String> getSubSequence(String s) {

        // base case
        ArrayList<String> ans = new ArrayList<>();
        if (s.length() == 0) {
            ans.add("");
            return ans;
        }

        // Recursive Work
        char curr = s.charAt(0);
        ArrayList<String> smallAns = getSubSequence(s.substring(1));

        // Self-Work
        for (String string : smallAns) {
            ans.add(string);
            ans.add(curr + string);
        }
        return ans;
    }

    static void printSubSequence(String s, String currAnswer) {

        // base case
        if (s.length() == 0) {
            System.out.println(currAnswer);
            return;
        }

        char curr = s.charAt(0);
        String remString = s.substring(1);

        printSubSequence(remString, currAnswer + curr); // Add the curr
        printSubSequence(remString, currAnswer); // Do not add the curr

    }

    public static void main(String[] args) {
        // ArrayList<String> ans = getSubSequence("abc");
        // System.out.println(ans.toString());
        printSubSequence("abc", "");
    }
}
