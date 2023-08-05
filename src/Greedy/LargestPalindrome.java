package Greedy;

import java.util.ArrayList;
import java.util.List;

public class LargestPalindrome {

    // Time Complexity - O(N), Auxiliary Space - O(1)
    public static void main(String[] args) {
        String number = "313551";

        // Initializing frequency list.
        List<Integer> frequency = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            frequency.add(0);
        }

        int n = number.length();
        for (int i = 0; i < n; i++) {
            int digit = number.charAt(i) - '0';
            frequency.set(digit, frequency.get(digit) + 1);
        }

        if (!validate(frequency)) {
            System.out.println("Palindrome is not possible.");
            return;
        }

        StringBuilder result = new StringBuilder();
        StringBuilder first = new StringBuilder();
        StringBuilder odd = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while ((frequency.get(i) > 1)) {
                first.append(i);
                frequency.set(i, frequency.get(i) - 2);
            }
            if (frequency.get(i) == 1) odd.append(i);
        }

        result.append(first);
        if (!odd.isEmpty()) result.append(odd);
        first.reverse();
        result.append(first);
        System.out.println(result);
    }

    private static boolean validate(List<Integer> frequency) {
        boolean isOdd = false;
        for (Integer number : frequency) {
            if (number % 2 != 0) {
                if (isOdd) {
                    return false;
                }
                isOdd = true;
            }
        }
        return true;
    }
}
