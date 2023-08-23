package Recursion;

import java.util.ArrayList;

public class AllOccurrences {

    static ArrayList<Integer> allIndices(int[] arr, int n, int x, int idx) {
        if (idx >= n)
            return new ArrayList<>();

        ArrayList<Integer> ans = new ArrayList<>();
        if (arr[idx] == x)
            ans.add(idx);

        ans.addAll(allIndices(arr, n, x, idx + 1));
        return ans;
    }

    public static void main(String[] args) {

    }
}
