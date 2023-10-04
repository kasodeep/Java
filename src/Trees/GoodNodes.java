package Trees;

public class GoodNodes {

    public static int helper(Node root, int max) {
        if (root == null) return 0;
        int ans = root.val < max ? 0 : 1;

        int left = helper(root.left, Math.max(root.val, max));
        int right = helper(root.right, Math.max(root.val, max));
        return left + right + ans;
    }

    public static int goodNodes(Node root) {
        return helper(root, Integer.MIN_VALUE);
    }

    public static void main(String[] args) {

    }
}
