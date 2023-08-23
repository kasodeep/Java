package Recursion;

public class KeyPad {

    static void combination(String digit, String[] kp, String res) {
        if (digit.length() == 0) {
            System.out.print(res + " ");
            return;
        }

        // Self-Work
        int currNum = digit.charAt(0) - '0';
        String currChoices = kp[currNum];

        // Recursive Work
        for (int i = 0; i < currChoices.length(); i++) {
            combination(digit.substring(1), kp, res + currChoices.charAt(i));
        }
    }

    public static void main(String[] args) {
        String digit = "253";
        String[] kp = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combination(digit, kp, "");
    }
}
