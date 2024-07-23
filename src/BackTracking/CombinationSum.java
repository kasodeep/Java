package BackTracking;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum {

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(A.get(0));

        for (int i = 1; i < A.size(); i++) {
            if (A.get(i).equals(A.get(i - 1))) continue;
            else arr.add(A.get(i));
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        helper(arr, B, new ArrayList<>(), res, 0, 0);

        return res;
    }

    static void helper(ArrayList<Integer> arr, int B, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res, int sum, int ind) {
        if (sum > B) return;

        if (sum == B) {
            res.add(list);
        }

        for (int i = ind; i < arr.size(); i++) {
            list.add(arr.get(i));
            sum += arr.get(i);

            helper(arr, B, new ArrayList<>(list), res, sum, i);

            list.remove(list.size() - 1);
            sum -= arr.get(i);
        }
    }
}
