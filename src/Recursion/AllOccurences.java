package Recursion;

import java.util.ArrayList;

public class AllOccurences {

    static ArrayList<Integer> allIndices(int[] arr, int n, int x, int idx) {

        // Base Case
        if (idx >= n)
            return new ArrayList<Integer>();

        // Self-Work
        ArrayList<Integer> ans = new ArrayList<>();
        if (arr[idx] == x)
            ans.add(idx);

        // Recursion
        ans.addAll(allIndices(arr, n, x, idx + 1));
        return ans;
    }

    public static void main(String[] args) {

    }
}
