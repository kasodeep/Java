package Recursion;

import java.util.ArrayList;

public class GetSSQ {

    /**
     * 
     * @param s - It is the string which is to be used for getting SSQ
     * @return - It returns the ArrayList containing all the subsequences
     */
    static ArrayList<String> getSubSequence(String s) {

        // Base Case
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

    /**
     * 
     * @param s          - It is the string which is to be used for getting SSQ
     * @param currAnswer - It is the current answer, initially zero
     */
    static void printSubSequence(String s, String currAnswer) {

        // base case
        if (s.length() == 0) {
            System.out.println(currAnswer);
            return;
        }

        char curr = s.charAt(0);
        String remString = s.substring(1);

        // Add the curr character
        printSubSequence(remString, currAnswer + curr);

        // Do not add the curr character
        printSubSequence(remString, currAnswer);

    }

    public static void main(String[] args) {
        ArrayList<String> ans = getSubSequence("abc");
        System.out.println(ans.toString());

        printSubSequence("abc", "");
    }
}
