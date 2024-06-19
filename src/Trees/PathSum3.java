package Trees;

import java.util.HashMap;

public class PathSum3 {

    static int count = 0;

    public static int sumK(Node root, int k) {
        count = 0;
        HashMap<Long, Integer> hm = new HashMap<>();

        solve(root, k, 0, hm);
        return count;
    }

    public static void solve(Node root, long k, long sum, HashMap<Long, Integer> hm) {
        if (root == null) return;

        sum += root.val;
        count += hm.getOrDefault(sum - k, 0);
        if (sum == k) count++;

        hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        solve(root.left, k, sum, hm);
        solve(root.right, k, sum, hm);
        hm.put(sum, hm.getOrDefault(sum, 0) - 1);
    }
}
