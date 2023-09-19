package Trees;

public class SumTree {
    static boolean f = true;

    public static int check(Node root) {
        int s = 0;
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        int l = check(root.left);
        int r = check(root.right);
        if (l + r != root.val) f = false;
        return l + r + root.val;
    }

    static boolean isSumTree(Node root) {
        check(root);
        return f;
    }

    public int sum(Node root) {
        if (root == null) return 0;
        int oldLeft = root.left != null ? root.left.val : 0;
        int oldRight = root.right != null ? root.right.val : 0;

        int left = sum(root.left);
        int right = sum(root.right);

        root.val = oldLeft + oldRight + left + right;
        return root.val;
    }

    public void toSumTree(Node root) {
        if (root == null) return;
        sum(root);
    }
}
