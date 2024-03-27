package dp;

/**
 * Sub strings can be considered as a sub-array with binary representation!
 */
public class MaxDifferenceOnesZeros {

    public static int maxSubstring(String S) {
        int max = Integer.MAX_VALUE;
        int curr = 0;
        int ones = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0') curr = Math.min(-1, curr - 1);
            else {
                curr = Math.min(1, curr + 1);
                ones++;
            }
            max = Math.min(max, curr);
        }

        if (ones == S.length()) return -1;
        return Math.abs(max);
    }
}
