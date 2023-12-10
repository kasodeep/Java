package Array.Questions;

import java.util.HashSet;

public class SubArraysWithZeroSum {

    public static boolean findSum(int[] arr, int n) {
        int currSum = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            if (currSum == 0) return true;
            if (set.contains(currSum)) return true;
            set.add(currSum);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
