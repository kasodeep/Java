package Trees;

import static Trees.ConstructTree.construct;

public class PathSum3 {
    public static int pathSum(Node root, int targetSum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && targetSum == root.val) {
            return 1;
        }

        return helper(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public static int helper(Node root, long target) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (target == root.val) {
            ans++;
        }

        return ans + helper(root.left, target - root.val) + helper(root.right, target - root.val);
    }

    public static void main(String[] args) {
        String[] arr = {"1000000000", "1000000000", "", "294967296", "", "1000000000", "", "1000000000", "", "1000000000"};
        Node root = construct(arr);
        System.out.println(pathSum(root, 0));
    }
}
