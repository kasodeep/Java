package Daily.GfG;

import java.util.ArrayList;

public class KSumPaths {

    static int count = 0;

    public static void helper(TreeNode root, int k, ArrayList<Integer> path) {
        if (root == null) return;

        path.add(root.val);
        int size = path.size();
        int sum = 0;

        for (int i = size - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k) count++;
        }

        helper(root.left, k, path);
        helper(root.right, k, path);
        path.remove(path.size() - 1);
    }

    public static int sumK(TreeNode root, int k) {
        ArrayList<Integer> path = new ArrayList<>();
        helper(root, k, path);
        return count;
    }

    public static void main(String[] args) {

    }
}
